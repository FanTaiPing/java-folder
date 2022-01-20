/*
*  Copyright 2019-2020 Zheng Jie
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package me.zhengjie.work.rest;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import me.zhengjie.annotation.Log;
import me.zhengjie.work.domain.TbWork;
import me.zhengjie.work.service.TbWorkService;
import me.zhengjie.work.service.dto.TbWorkDto;
import me.zhengjie.work.service.dto.TbWorkQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author GaoJingBo
* @date 2021-09-26
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "作业管理管理")
@RequestMapping("/api/tbWork")
public class TbWorkController {

    @Value("${spring.datasource.druid.url}")
    String url;

    @Value("${spring.datasource.druid.driverClassName}")
    String driverClassName;

    @Value("${spring.datasource.druid.username}")
    String userName;

    @Value("${spring.datasource.druid.password}")
    String pwd;

    private final TbWorkService tbWorkService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, TbWorkQueryCriteria criteria) throws IOException {
        tbWorkService.download(tbWorkService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询作业管理")
    @ApiOperation("查询作业管理")
    public ResponseEntity<Object> query(TbWorkQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tbWorkService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增作业管理")
    @ApiOperation("新增作业管理")
    public ResponseEntity<Object> create(@Validated @RequestBody TbWork resources){

        //使用Spring JDBC完成

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(pwd);

        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "INSERT INTO tb_work( `work_code`, `name`, `work_desc`, `cr_teacher_id`, `cr_teacher_name`, `cr_class_id`, `cr_class_name`, `cr_student_id`, `cr_student_name`, `proess`, `work_state`) VALUES ";

        List<TbWorkDto> resList = new ArrayList<TbWorkDto>();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");

        String format = sdf.format(new Date());

        //前端传来的数据crStudentName是特殊格式:如1,张三;2,李四;3,王五
        //1.拆分数组，成为[1,张三  2,李四  3,王五]
        String[] stuArr = resources.getCrStudentName().split(";");
        //2.循环，单个下标拆出人和id
        for(int i=0;i<stuArr.length;i++){
            //2.1 拆分拆分数组，成为[1,张三]
            String[] userArr = stuArr[i].split(",");
            Integer id = Integer.valueOf(userArr[0]);
            String name = userArr[1];
            resources.setWorkCode("WORK-"+resources.getCrClassName()+"-"+name+"-"+format);
            resources.setCrStudentId(id);
            resources.setCrStudentName(name);

            if(i==0){
                sql += "(" +
                        "\t'"+resources.getWorkCode()+"',\n" +
                        "\t'"+resources.getName()+"',\n" +
                        "\t'"+resources.getWorkDesc()+"',\n" +
                        "\t"+resources.getCrTeacherId()+",\n" +
                        "\t'"+resources.getCrTeacherName()+"',\n" +
                        "\t"+resources.getCrClassId()+",\n" +
                        "\t'"+resources.getCrClassName()+"',\n" +
                        "\t"+id+", \n" +
                        "\t'"+name+"',\n" +
                        "\t0,\n" +
                        "\t1 )";
            }else{
                sql += ",(" +
                        "\t'"+resources.getWorkCode()+"',\n" +
                        "\t'"+resources.getName()+"',\n" +
                        "\t'"+resources.getWorkDesc()+"',\n" +
                        "\t"+resources.getCrTeacherId()+",\n" +
                        "\t'"+resources.getCrTeacherName()+"',\n" +
                        "\t"+resources.getCrClassId()+",\n" +
                        "\t'"+resources.getCrClassName()+"',\n" +
                        "\t"+id+", \n" +
                        "\t'"+name+"',\n" +
                        "\t0,\n" +
                        "\t1 )";
            }

        }

        template.execute(sql);
        System.out.println("执行sql：\n"+sql);

        return new ResponseEntity<>(resList,HttpStatus.CREATED);
    }




    @PutMapping
    @Log("修改作业管理")
    @ApiOperation("修改作业管理")
    public ResponseEntity<Object> update(@Validated @RequestBody TbWork resources){
        tbWorkService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除作业管理")
    @ApiOperation("删除作业管理")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        tbWorkService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}