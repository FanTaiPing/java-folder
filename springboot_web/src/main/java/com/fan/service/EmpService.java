package com.fan.service;

import com.fan.entity.Emp;

import java.util.List;

public interface EmpService {
    /**
     * 查询所员工的信息
     * @return
     */
    List<Emp>  findAll();

    /**
     * 添加员工
     * @return
     */
    void addEmp(Emp emp);

    /**
     * 根据员工id查询员工信息，用于修改员工
     * @param id
     * @return
     */
    Emp getById(int id);
    /**
     * 根据员工id修改员工信息
     * @param emp
     * @return
     */
    int updateEmp(Emp emp);
    /**
     *根据id删除员工信息
     * @param id
     * @return
     */
    int deleteEmp(int id);
}
