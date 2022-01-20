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
package me.zhengjie.teacher.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.teacher.domain.TbTeacher;
import me.zhengjie.teacher.service.TbTeacherService;
import me.zhengjie.teacher.service.dto.TbTeacherQueryCriteria;
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
* @date 2021-09-23
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "教师信息管理管理")
@RequestMapping("/api/tbTeacher")
public class TbTeacherController {

    private final TbTeacherService tbTeacherService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, TbTeacherQueryCriteria criteria) throws IOException {
        tbTeacherService.download(tbTeacherService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询教师信息管理")
    @ApiOperation("查询教师信息管理")
    public ResponseEntity<Object> query(TbTeacherQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tbTeacherService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增教师信息管理")
    @ApiOperation("新增教师信息管理")
    public ResponseEntity<Object> create(@Validated @RequestBody TbTeacher resources){
        return new ResponseEntity<>(tbTeacherService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改教师信息管理")
    @ApiOperation("修改教师信息管理")
    public ResponseEntity<Object> update(@Validated @RequestBody TbTeacher resources){
        tbTeacherService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除教师信息管理")
    @ApiOperation("删除教师信息管理")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        tbTeacherService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}