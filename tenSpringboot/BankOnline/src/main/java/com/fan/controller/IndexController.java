package com.fan.controller;

import com.fan.entity.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session){
        if(session.getAttribute("account") !=null){
           session.removeAttribute("account");
        }

        return "redirect:/login";
    }
    @GetMapping("main")
    public String main(Model model, String flag, HttpSession session) {
        if(session.getAttribute("account")== null){
            return "redirect:/login";
        }
        Account account = (Account) session.getAttribute("account");
        if (flag == null || "".equals(flag)) {
            model.addAttribute("url", "welcome");
            session.setAttribute("user","卡号："+account.getCardNo());

        }
        else if (flag.equals("balance")) {
            model.addAttribute("url", "account/balance");
        }else if(flag.equals("transfer")){
            model.addAttribute("url", "transfer");
        }else if(flag.equals("success")){
            model.addAttribute("url", "success");
        }

        return "main";

    }

    @GetMapping("welcome")
    public String welcome() {
        return "welcome";
    }
    @GetMapping("transfer")
    public String transfer(){
        return "transfer";
    }
    @GetMapping("success")
    public String success(){
        return "success";
    }
}
