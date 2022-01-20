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
package me.zhengjie.interview.rest;

import me.zhengjie.annotation.Log;
import me.zhengjie.interview.domain.TbInterview;
import me.zhengjie.interview.service.TbInterviewService;
import me.zhengjie.interview.service.dto.TbInterviewQueryCriteria;
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
* @date 2021-09-30
**/
@RestController
@RequiredArgsConstructor
@Api(tags = "面试记录管理")
@RequestMapping("/api/tbInterview")
public class TbInterviewController {

    private final TbInterviewService tbInterviewService;

    @Log("导出数据")
    @ApiOperation("导出数据")
    @GetMapping(value = "/download")
    @PreAuthorize("@el.check('tbInterview:list')")
    public void download(HttpServletResponse response, TbInterviewQueryCriteria criteria) throws IOException {
        tbInterviewService.download(tbInterviewService.queryAll(criteria), response);
    }

    @GetMapping
    @Log("查询面试记录")
    @ApiOperation("查询面试记录")
    @PreAuthorize("@el.check('tbInterview:list')")
    public ResponseEntity<Object> query(TbInterviewQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity<>(tbInterviewService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @PostMapping
    @Log("新增面试记录")
    @ApiOperation("新增面试记录")
    @PreAuthorize("@el.check('tbInterview:add')")
    public ResponseEntity<Object> create(@Validated @RequestBody TbInterview resources){
        return new ResponseEntity<>(tbInterviewService.create(resources),HttpStatus.CREATED);
    }

    @PutMapping
    @Log("修改面试记录")
    @ApiOperation("修改面试记录")
    @PreAuthorize("@el.check('tbInterview:edit')")
    public ResponseEntity<Object> update(@Validated @RequestBody TbInterview resources){
        tbInterviewService.update(resources);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Log("删除面试记录")
    @ApiOperation("删除面试记录")
    @PreAuthorize("@el.check('tbInterview:del')")
    @DeleteMapping
    public ResponseEntity<Object> delete(@RequestBody Integer[] ids) {
        tbInterviewService.deleteAll(ids);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}