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
package me.zhengjie.student.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.student.domain.TbStudent;
import me.zhengjie.student.service.TbStudentService;
import me.zhengjie.student.service.dto.TbStudentQueryCriteria;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @author GaoJingBo
* @date 2021-09-18
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "学生信息管理管理")
@RequestMapping("/api/tbStudent")
public class TbStudentController {

    private final TbStudentService tbStudentService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, TbStudentQueryCriteria criteria) throws IOException {
        tbStudentService.download(tbStudentService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询学生信息管理")
    @ApiOperation("查询学生信息管理")
    public ResponseEntity<Object> query(TbStudentQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tbStudentService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增学生信息管理")
    @ApiOperation("新增学生信息管理")
    public ResponseEntity<Object> create(@Validated @RequestBody TbStudent resources){
        return new ResponseEntity<>(tbStudentService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改学生信息管理")
    @ApiOperation("修改学生信息管理")
    public ResponseEntity<Object> update(@Validated @RequestBody TbStudent resources){
        tbStudentService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除学生信息管理")
    @ApiOperation("删除学生信息管理")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        tbStudentService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}