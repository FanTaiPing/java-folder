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

//@Controller
@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @Autowired
    private RecordService recordService;

    /**
     * 登录时验证账号密码
     *
     * @param account
     * @param session
     * @return
     */
    @PostMapping(value = "login", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object login(@RequestBody Account account, HttpSession session) {
        Account login = accountService.login(account.getCardNo());
        session.setAttribute("password", login.getPassword());
        session.setAttribute("cardNo", login.getCardNo());
//        System.out.println(login);
//        System.out.println(account);
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

    /**
     * 查询余额功能
     *
     * @param model
     * @param session
     * @return
     */
    @GetMapping("balance")
    public String getBalance(Model model, HttpSession session) {

        Account account = accountService.getAccountByCode(((Account) session.getAttribute("account")).getCardNo());
//        Double balance = accountService.getAccountByCode(account.getCardNo());
        model.addAttribute("balance", "人民币:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + account.getBalance());

        return "balance";
    }

    /**
     * 转账功能
     *
     * @param account
     * @param session
     * @return
     */
    @PostMapping(value = "transfer", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object transfer(@RequestBody Account account, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>(16);
        //账户不存在
        // targetAccount : 目标账户（要转账的账户）
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
        // transferAccount : 转账账户
        Account transferAccount = (Account) session.getAttribute("account");
        if (transferAccount.getBalance() - account.getBalance() < 0) {
            map.put("success", "false");
            map.put("msg", "转账失败！转出账户余额不足!");
            return map;
        }


        //添加两条记录到转账记录表  一条转出卡的记录，一条转入卡的记录
        Record getMoney = new Record();
        getMoney.setCardNo(transferAccount.getCardNo());
        getMoney.setTransactionType("取款");
        getMoney.setExpense(account.getBalance());
        getMoney.setIncome(0);
        getMoney.setBalance(transferAccount.getBalance() - account.getBalance());
        getMoney.setTransactionDate(new Date());


        Record setMoney = new Record();
        setMoney.setCardNo(targetAccount.getCardNo());
        setMoney.setTransactionType("存款");
        setMoney.setExpense(0);
        setMoney.setIncome(account.getBalance());
        setMoney.setBalance(targetAccount.getBalance() + account.getBalance());
        setMoney.setTransactionDate(new Date());

        recordService.insertRecord(getMoney);
        recordService.insertRecord(setMoney);

        //转账
        //转出账户
        accountService.updateMoney(account.getBalance(), "sub", transferAccount.getCardNo());
        //转入账户
        accountService.updateMoney(account.getBalance(), "add", targetAccount.getCardNo());
        map.put("success", "true");
        map.put("msg", "转账成功！");
        return map;
    }

    @PostMapping("updatePassword")
//    @ResponseBody
    public Object updatePassword(@RequestParam("password") String password, @RequestParam("newPassword") String newPassword, @RequestParam("confirmPassword") String confirmPassword, @RequestParam("cardNo") Long cardNo) {
        Account account = accountService.login(cardNo);
        Map<String, Object> map = new HashMap<>(16);
        if (!password.equals(account.getPassword())) {
            map.put("success", false);
            map.put("msg", "您输入的当前账号的密码不正确，请重新输入！");
            return map;
        }
        if (!newPassword.equals(confirmPassword)) {
            map.put("success", false);
            map.put("msg", "两次输入的密码不一致，请重新输入！");
            return map;
        }
        if (newPassword.equals(confirmPassword) && password.equals(account.getPassword())) {
            accountService.updatePassword(newPassword, cardNo);
            map.put("success", true);
            map.put("msg", "修改密码成功！");
            return map;
        }else {
            return null;
        }
    }
}
