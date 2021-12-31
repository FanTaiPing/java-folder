package com.fan.controller;

import com.fan.entity.Account;
import com.fan.entity.Record;
import com.fan.service.RecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private RecordService recordService;

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        if (session.getAttribute("account") != null) {
            session.removeAttribute("account");
        }

        return "redirect:/login";
    }

    @GetMapping("main")
    public String main(Model model, String flag, HttpSession session) {
        if (session.getAttribute("account") == null) {
            return "redirect:/login";
        }
        Account account = (Account) session.getAttribute("account");
        if (flag == null || "".equals(flag)) {
            model.addAttribute("url", "welcome");
            session.setAttribute("user", "卡号：" + account.getCardNo());
        } else if (flag.equals("balance")) {
            model.addAttribute("url", "account/balance");
        } else if (flag.equals("transfer")) {
            model.addAttribute("url", "transfer");
        } else if (flag.equals("success")) {
            model.addAttribute("url", "success");
        } else if (flag.equals("transactionRecord")) {
            model.addAttribute("url", "transactionRecord");
        } else if (flag.equals("updatePassword")) {
            model.addAttribute("url", "updatePassword");
        }

        return "main";

    }

    /**
     * 跳转到欢迎页面
     *
     * @return
     */
    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 跳转到转账页面
     *
     * @return
     */
    @GetMapping("transfer")
    public String transfer() {
        return "transfer";
    }

    /**
     * 跳转到转账成功页面
     *
     * @return
     */
    @GetMapping("success")
    public String success() {
        return "success";
    }

    /**
     * 跳转到交易记录查询页面
     *
     * @return
     */
    @GetMapping("transactionRecord")
    public String transactionRecord(Model model, Integer pageCurrent) {
        //每页显示的数据条数
//        Integer pageSize = 2;
        if (pageCurrent == null) {
            pageCurrent = 1;
        }
        //分页查询，startPage是告诉拦截器要开始分页了
        PageHelper.startPage(pageCurrent, 3);
        List<Record> allRecord = recordService.findAllRecord();
        //navigatePages:3 代表分页导航栏的页码数  PageInfo：将查询到的信息列表放到其中，按照3页3页的分开存储在pageInfo中
        PageInfo pageInfo = new PageInfo(allRecord, 3);
        allRecord.forEach(System.out::println);
        System.out.println(pageInfo);
        //将查到的所有信息存到attribute中
        model.addAttribute("allRecord", allRecord);
        //将
        model.addAttribute("pageInfo", pageInfo);

        return "transactionRecord";
    }

    @PostMapping("transactionRecord")
    public String findRecord(Model model, Integer pageCurrent, @RequestParam String dateOne, @RequestParam String dateTwo) throws ParseException {
        //每页显示的数据条数
//        Integer pageSize = 2;
        if (pageCurrent == null) {
            pageCurrent = 1;
        }
        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        //分页查询，startPage是告诉拦截器要开始分页了
        PageHelper.startPage(pageCurrent, 3);
        List<Record> record = recordService.findRecord(dateFormat.parse(dateOne),dateFormat.parse(dateTwo));
        //navigatePages:3 代表分页导航栏的页码数  PageInfo：将查询到的信息列表放到其中，按照3页3页的分开存储在pageInfo中
        PageInfo pageInfoSelect = new PageInfo(record, 3);
        record.forEach(System.out::println);
        System.out.println(pageInfoSelect);
        //将查到的所有信息存到attribute中
        model.addAttribute("allRecord", record);
        //将
        model.addAttribute("pageInfo", pageInfoSelect);

        return "transactionRecord";
    }
//    @InitBinder
//    public void initBinder(WebDataBinder binder, WebRequest request) {
//        //转换日期 注意这里的转化要和传进来的字符串的格式一直 如2015-9-9 就应该为yyyy-MM-dd
//        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
//}

    /**
     * 跳转到修改密码界面
     *
     * @return
     */
    @GetMapping("updatePassword")
    public String updatePassword() {

        return "updatePassword";
    }
}
