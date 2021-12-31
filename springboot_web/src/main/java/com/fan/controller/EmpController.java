package com.fan.controller;

import com.fan.entity.Emp;
import com.fan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("addEmp")
    public String addEmp() {

        return "pages/addEmp";
    }

    @PostMapping("addEmp")
    public String addEmp(Emp emp) {
        try {
            empService.addEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/user/empFindAll";
    }

    @GetMapping("updateEmp")
    public String updateEmp(int id, Model model) {
        model.addAttribute("emp", empService.getById(id));
        return "pages/updateEmp";
    }

    @PostMapping("updateEmp")
    public String updateEmp(Emp emp) {
        try {
            empService.updateEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/empFindAll";
    }

    @GetMapping("deleteEmp")
    public String deleteEmp(int id) {
        try {
            empService.deleteEmp(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/empFindAll";
    }
}
