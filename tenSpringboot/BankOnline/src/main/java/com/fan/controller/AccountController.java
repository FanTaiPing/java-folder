package com.fan.controller;

import com.fan.entity.Account;

import com.fan.entity.Record;
import com.fan.service.AccountService;
import com.fan.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RecordService recordService;

    @PostMapping(value = "login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object login(@RequestBody Account account, HttpSession session) {
        Account login = accountService.login(account.getCardNo());
        System.out.println(login);
        System.out.println(account);
        Map<String, Object> map = new HashMap<String, Object>(16);
        //账户不存在
        if (login == null) {
            map.put("success", false);
            map.put("msg", "登录失败！你输入的卡号不存在！");
            return map;
        }
        //密码不正确
        if (!account.getPassword().equals(login.getPassword())) {
            map.put("success", false);
            map.put("msg", "登录失败！密码错误！");
            return map;
        }
        //账户已冻结
        if (login.getStatus() == 0) {
            map.put("success", false);
            map.put("msg", "登录失败！账户已冻结！");
            return map;
        }
        //登录成功，保存当前用户
        session.setAttribute("account", login);
        map.put("success", true);
        map.put("msg", "登录成功！");
        return map;
    }

    @GetMapping("balance")
    public String getBalance(Model model, HttpSession session) {

        Account account = (Account) session.getAttribute("account");
//        Double balance = accountService.getAccountByCode(account.getCardNo());
        model.addAttribute("balance", "人民币:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + account.getBalance());

        return "balance";
    }

    @PostMapping(value = "transfer", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object transfer(@RequestBody Account account, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>(16);
        //账户不存在
        Account targetAccount = accountService.login(account.getCardNo());
        if (targetAccount == null) {
            map.put("success", "false");
            map.put("msg", "转账失败！目标账户不存在!");
            return map;
        }
        //账户已冻结
        if (targetAccount.getStatus() == 0) {
            map.put("success", "false");
            map.put("msg", "转账失败！转账账户已冻结!");
            return map;
        }
        //转出账户余额不足
        Account transferAccount = (Account) session.getAttribute("account");
        if (transferAccount.getBalance() - account.getBalance() < 0) {
            map.put("success", "false");
            map.put("msg", "转账失败！转出账户余额不足!");
            return map;
        }
        //添加一条记录
        Record getMoney = new Record();
        getMoney.setCardNo(transferAccount.getCardNo());
        getMoney.setTransaction_type("取款");
        getMoney.setExpense(account.getBalance());
        getMoney.setIncome(0);
        getMoney.setBalance(transferAccount.getBalance());
        getMoney.setTransaction_date(new Date());


        Record setMoney = new Record();
        setMoney.setCardNo(targetAccount.getCardNo());
        setMoney.setTransaction_type("存款");
        setMoney.setExpense(0);
        setMoney.setIncome(account.getBalance());
        setMoney.setBalance(targetAccount.getBalance());
        setMoney.setTransaction_date(new Date());


        //转账
        accountService.updateMoney(account.getBalance(), "sub", transferAccount.getCardNo());
        accountService.updateMoney(account.getBalance(), "add", targetAccount.getCardNo());
        recordService.insertRecord(getMoney);
        recordService.insertRecord(setMoney);
        map.put("success",true);
        return map;
    }
}
