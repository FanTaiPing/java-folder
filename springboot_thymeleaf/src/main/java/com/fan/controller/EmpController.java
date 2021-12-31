package com.fan.controller;

import com.fan.entity.Emp;
import com.fan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("empFindAll")
    public String login(Model model) {
        try {
            List<Emp> empList = empService.empFindAll();
            model.addAttribute("empList", empList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "emplist";
    }

    @GetMapping("addEmp")
    public String addEmp() {

        return "addEmp";
    }

    @PostMapping("addEmp")
    public String addEmp(Emp emp) {
        try {
            empService.addEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/emp/empFindAll";
    }

    @GetMapping("updateEmp")
    public String updateEmp(int id, Model model) {
        model.addAttribute("emp", empService.getEmpById(id));

        return "updateEmp";
    }

    @PostMapping("updateEmp")
    public String updateEmp(Emp emp) {
        try {
            empService.updateEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/emp/empFindAll";
    }

    @GetMapping("deleteEmp")
    public String deleteEmp(int id) {
        try {
            empService.deleteEmp(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/emp/empFindAll";
    }
}
