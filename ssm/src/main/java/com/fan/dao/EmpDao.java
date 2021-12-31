package com.fan.dao;

import com.fan.entity.Emp;

import java.util.List;


/**
 * @author y
 */
public interface EmpDao {
    /**
     * 查询员工所有信息
     * @return
     */
    List<Emp> findAll();

    /**
     * 添加员工
     * @param emp
     */
    void insertEmp(Emp emp);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Emp getById(int id);

    /**
     * 更新员工信息
     * @param emp
     * @return
     *
     */
    int updateEmp(Emp emp);

    /**
     * 删除员工
     * @param emp
     * @return
     */
    int deleteEmp(Emp emp);
}
