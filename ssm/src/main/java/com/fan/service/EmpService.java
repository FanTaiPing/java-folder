package com.fan.service;


import com.fan.entity.Emp;

import java.util.List;

/**
 * @author y
 */
public interface EmpService {
    /**
     *查询员工
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
     * @return 注意:返回值得类型是int，如果写成Emp也可以执行，但在springboot中
     *      *  会报返回值类型不匹配的异常
     */
    int updateEmp(Emp emp);

    /**
     * 删除员工
     * @param emp
     * @return 注意:返回值得类型是int，如果写成Emp也可以执行，但在springboot中
     *      *  会报返回值类型不匹配的异常
     */
    int deleteEmp(Emp emp);
}
