
package me.zhengjie.modules.train.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import me.zhengjie.annotation.AnonymousAccess;
import me.zhengjie.modules.system.service.DeptService;
import me.zhengjie.modules.train.entity.Interview;
import me.zhengjie.modules.train.service.IInterviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@RestController
@RequiredArgsConstructor
@Api(tags = "教学管理系统")
@RequestMapping("/api/interviewPage")
public class TrainController {

    private final DeptService deptService;
    private static final String ENTITY_NAME = "dept";

    @Resource
    IInterviewService interviewService;

    @ApiOperation("查询部门")
    @GetMapping("/get/{id}")
    @AnonymousAccess
    public ResponseEntity<Object> query(@PathVariable String id) throws Exception {
        String value="dddd"+id;
        Interview interview = interviewService.getById(id);
        return new ResponseEntity<>(interview,HttpStatus.OK);
    }

}