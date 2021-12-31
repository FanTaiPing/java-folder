package com.fan.service.impl;

import com.fan.dao.EmpDao;
import com.fan.service.EmpService;

/**
 * @author y
 */
public class EmpServiceImpl implements EmpService {

    private EmpDao empDao;
    private EmpDao empDaoTwo;

    public void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    public void setEmpDaoTwo(EmpDao empDaoTwo) {
        this.empDaoTwo = empDaoTwo;
    }

    @Override
    public String getEmpById(int id) {
        return empDaoTwo.getEmpById(2) + "\nService里的方法：id是" + id + "的用户是：张三";
    }

    public void initEmpService(){
        System.out.println("Spring 工厂初始化...\nempService初始化成功");
    }

    public void destoryEmpService(){
        System.out.println("Spring 工厂销毁...\nempService销毁成功");
    }
}
