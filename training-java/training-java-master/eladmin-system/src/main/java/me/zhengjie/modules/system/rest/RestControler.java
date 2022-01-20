package me.zhengjie.modules.system.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import me.zhengjie.annotation.AnonymousAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "系统-服务监控管理")
@RequestMapping("/api/test")
public class RestControler {


    @GetMapping("/index")
    @ApiOperation("查询服务监控")
    @AnonymousAccess
    public ResponseEntity<Object> query() {
        return new ResponseEntity<>("demo test", HttpStatus.OK);
    }
}