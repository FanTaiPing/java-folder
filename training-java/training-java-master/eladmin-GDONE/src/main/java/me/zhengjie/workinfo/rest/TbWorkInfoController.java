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
package me.zhengjie.workinfo.rest;

import com.alibaba.druid.pool.DruidDataSource;
import me.zhengjie.annotation.Log;
import me.zhengjie.workinfo.domain.TbWorkInfo;
import me.zhengjie.workinfo.service.TbWorkInfoService;
import me.zhengjie.workinfo.service.dto.TbWorkInfoDto;
import me.zhengjie.workinfo.service.dto.TbWorkInfoQueryCriteria;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author GaoJingBo
* @date 2021-09-27
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "作业提交记录管理")
@RequestMapping("/api/tbWorkInfo")
public class TbWorkInfoController {

    private final TbWorkInfoService tbWorkInfoService;

    @Value("${spring.datasource.druid.url}")
    String url;

    @Value("${spring.datasource.druid.driverClassName}")
    String driverClassName;

    @Value("${spring.datasource.druid.username}")
    String userName;

    @Value("${spring.datasource.druid.password}")
    String pwd;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, TbWorkInfoQueryCriteria criteria) throws IOException {
        tbWorkInfoService.download(tbWorkInfoService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询作业提交记录")
    @ApiOperation("查询作业提交记录")
    public ResponseEntity<Object> query(TbWorkInfoQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tbWorkInfoService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @GetMapping("/list")
    @Log("查询作业提交记录(不分页)")
    @ApiOperation("查询作业提交记录(不分页)")
    public ResponseEntity<Object> queryList(TbWorkInfoQueryCriteria criteria){

        //使用Spring JDBC完成

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(pwd);

        JdbcTemplate template = new JdbcTemplate(dataSource);

        String sql = "SELECT * FROM `tb_work_info` where work_id = "+criteria.getWorkId()+" order by take_time desc";

        List<Map<String, Object>> maps = template.queryForList(sql);

        return new ResponseEntity<>(maps,HttpStatus.OK);
    }

    @PostMapping
    @Log("新增作业提交记录")
    @ApiOperation("新增作业提交记录")
    public ResponseEntity<Object> create(@Validated @RequestBody TbWorkInfo resources){

        //使用Spring JDBC完成

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(pwd);

        JdbcTemplate template = new JdbcTemplate(dataSource);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        //修改任务内容的SQL
        String updateWorkSQL = "";

        //插入提交记录的SQL
        String insertInfoSQL = "INSERT INTO tb_work_info(info_desc, proess, work_id, comment, work_name, take_time, state) ";

        String state = resources.getState();

        if(state!=null){//教师提交

            String desc = "教师审核,"+state+";描述:"+resources.getInfoDesc();

            int stateCode = 1;

            if("进行中".equals(state)){
                stateCode = 1;
            }else if("已完成".equals(state)){
                stateCode = 2;
            }else if("合格".equals(state)){
                stateCode = 3;
            }else if("不合格".equals(state)){
                stateCode = 4;
            }else if("不合格继续进行".equals(state)){
                stateCode = 5;
            }

            updateWorkSQL = "update tb_work set  work_state="+stateCode+" where work_id = "+resources.getWorkId();

            insertInfoSQL += " VALUES ('"+desc+"', "+resources.getProess()+", "+resources.getWorkId()+", '"+resources.getComment()+"', '"+resources.getWorkName()+"', '"+(sdf.format(new Date()))+"', '"+state+"')";

        }else{//学员提交

            //判断进度进行状态的修改
            int proess = resources.getProess();
            if(proess == 100){//已完成

                String desc = "学员提交,任务完成;描述:"+resources.getInfoDesc();

                updateWorkSQL = "update tb_work set proess = 100, work_state=2 where work_id = "+resources.getWorkId();

                insertInfoSQL += " VALUES ('"+desc+"', "+resources.getProess()+", "+resources.getWorkId()+", '"+resources.getComment()+"', '"+resources.getWorkName()+"', '"+(sdf.format(new Date()))+"', '已完成')";

            }else{//未完成提交

                updateWorkSQL = "update tb_work set proess = "+resources.getProess()+" where work_id = "+resources.getWorkId();

                String desc = "学员提交,进度"+resources.getProess()+"%;描述:"+resources.getInfoDesc();

                insertInfoSQL += " VALUES ('"+desc+"', "+resources.getProess()+", "+resources.getWorkId()+", '"+resources.getComment()+"', '"+resources.getWorkName()+"', '"+(sdf.format(new Date()))+"', '进行中')";

            }

        }

        //执行
        template.execute(updateWorkSQL);

        template.execute(insertInfoSQL);


        return new ResponseEntity<>("提交成功",HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改作业提交记录")
    @ApiOperation("修改作业提交记录")
    public ResponseEntity<Object> update(@Validated @RequestBody TbWorkInfo resources){
        tbWorkInfoService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除作业提交记录")
    @ApiOperation("删除作业提交记录")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        tbWorkInfoService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}