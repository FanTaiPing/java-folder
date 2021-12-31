package com.fan.dao;

import com.fan.entity.Salary;

import java.util.List;

/**
 * @author y
 */
public interface SalaryDao {
    /**
     * 查询薪资表里面的所有数据
     * @return
     */
    List<Salary> findAllSalary();

    /**
     * 根据id查询员工的薪资表里的信息
     * @return
     */
    Salary getSalaryById();
}
