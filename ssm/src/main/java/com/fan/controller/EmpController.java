package com.fan.controller;

import com.fan.entity.Emp;
import com.fan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 员工表操作控制器
 * @author y
 */
@RequestMapping("emp")
@Controller
public class EmpController {
    /**
     * @Autowired :自动注入注解 ，不需要手动建set方法
     * private EmpService empService 注入service业务层员工类接口
     */
    @Autowired
    private EmpService empService;

    /**
     * 添加员工跳转到的jsp页面路径
     * @return
     */
    @GetMapping("addEmp")
    public String addEmp() {
        return "pages/addEmp";
    }

    /**
     * 添加员工时调用的方法  前端form提交表单时post请求的路径
     * @param emp
     * @return
     */
    @PostMapping("addEmp")
    public String addEmp(Emp emp) {
        try {
            empService.insertEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //跳转或empList页面
        return "redirect:/user/empFindAll";
    }

    /**
     * 修改员工跳转到的jsp页面路径
     * @param id
     * @param model
     * @return
     */
    @GetMapping("updateEmp")
    public String updateEmp(int id, Model model) {
        model.addAttribute("emp", empService.getById(id));
        return "pages/updateEmp";
    }

    /**
     * 修改员工时调用的方法  前端form提交表单时post请求的路径
     * @param emp
     * @return
     */
    @PostMapping("updateEmp")
    public String updateEmp(Emp emp){
        try{
            empService.updateEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/empFindAll";
    }

    /**
     * 删除员工时调用的方法，不需要进行表单提交请求，直接使用get即可
     * @param emp
     * @return
     */
    @GetMapping("deleteEmp")
    public String deleteEmp(Emp emp){
        try{
            empService.deleteEmp(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/user/empFindAll";
    }
}
