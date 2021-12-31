package com.fan.service;

import com.fan.entity.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 查询所有员工信息
     * @return
     */
    List<Emp> empFindAll();

    /**
     * 添加员工
     * @param emp
     * @return
     */
    int addEmp(Emp emp);
    /**
     * 根据员工id查询员工信息
     * @param id
     * @return
     */
    Emp getEmpById(int id);
    /**
     * 修改员工信息
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);
    /**
     * 根据id删除员工信息
     * @param id
     * @return
     */
    int deleteEmp(int id);
}
