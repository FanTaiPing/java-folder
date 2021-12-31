package com.fan.controller;

import com.fan.entity.Record;
import com.fan.service.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("record")
public class RecordController {
    @Autowired
    private RecordService recordService;


//    @GetMapping("transactionRecord")
//    public String findAllRecord(Model model, Integer pageCurrent) {
//        //每页显示的数据条数
//        Integer pageSize = 2;
//        if (pageCurrent == null) {
//            pageCurrent = 1;
//        }
//        //分页查询，startPage是告诉拦截器要开始分页了
//        PageHelper.startPage(pageCurrent, pageSize);
//        List<Record> allRecord = recordService.findAllRecord();
//        //navigatePages:3 代表分页导航栏的页码数  PageInfo：将查询到的信息列表放到其中，按照3页3页的分开存储在pageInfo中
//        PageInfo pageInfo = new PageInfo(allRecord, 3);
//        allRecord.forEach(System.out::println);
//        System.out.println(pageInfo);
//        //将查到的所有信息存到attribute中
//        model.addAttribute("allRecord", allRecord);
//        //将
//        model.addAttribute("pageInfo", pageInfo);
//
//        return "transactionRecord";
//    }

//    @PostMapping("findRecord")
//    public String findAllRecord(Model model, Integer pageCurrent, Date dateOne, Date dateTwo) {
//        //每页显示的数据条数
//        Integer pageSize = 2;
//        if (pageCurrent == null) {
//            pageCurrent = 1;
//        }
//        //分页查询，startPage是告诉拦截器要开始分页了
//        PageHelper.startPage(pageCurrent, pageSize);
//        List<Record> record = recordService.findRecord(dateOne, dateTwo);
//        //navigatePages:3 代表分页导航栏的页码数  PageInfo：将查询到的信息列表放到其中，按照3页3页的分开存储在pageInfo中
//        PageInfo pageInfoSelect = new PageInfo(record, 3);
//        record.forEach(System.out::println);
//        System.out.println(pageInfoSelect);
//        //将查到的所有信息存到attribute中
//        model.addAttribute("allRecord", record);
//        //将
//        model.addAttribute("pageInfo", pageInfoSelect);
//
//        return "transactionRecord";
//    }
}
