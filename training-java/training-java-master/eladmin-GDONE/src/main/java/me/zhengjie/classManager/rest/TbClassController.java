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
package me.zhengjie.classManager.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.classManager.domain.TbClass;
import me.zhengjie.classManager.service.TbClassService;
import me.zhengjie.classManager.service.dto.TbClassQueryCriteria;
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
@Api(tags = "班级管理管理")
@RequestMapping("/api/tbClass")
public class TbClassController {

    private final TbClassService tbClassService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    public void download(HttpServletResponse response, TbClassQueryCriteria criteria) throws IOException {
        tbClassService.download(tbClassService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询班级管理")
    @ApiOperation("查询班级管理")
    public ResponseEntity<Object> query(TbClassQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tbClassService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增班级管理")
    @ApiOperation("新增班级管理")
    public ResponseEntity<Object> create(@Validated @RequestBody TbClass resources){
        return new ResponseEntity<>(tbClassService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改班级管理")
    @ApiOperation("修改班级管理")
    public ResponseEntity<Object> update(@Validated @RequestBody TbClass resources){
        tbClassService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除班级管理")
    @ApiOperation("删除班级管理")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        tbClassService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}