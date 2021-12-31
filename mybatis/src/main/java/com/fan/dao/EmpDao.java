package com.fan.dao;

import com.fan.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author y
 */
public interface EmpDao {
    /**
     * 查询所有员工
     *
     * @return
     */
    List<Emp> findAll();

    /**
     * 根据Id查询员工
     *
     * @param id
     * @return
     */
    Emp getEmpById(int id);

    /**
     * 根据员工id和name查询
     * @param id
     * @param name
     * @return
     * 多参数需要加param注解，如下：
     */
    Emp getEmpByIdAndName(@Param("id") int id, @Param("name") String name);

    /**
     * 插入员工
     *
     * @param emp
     * @return
     */
    int insert(Emp emp);

    /**
     * 更新员工
     *
     * @param emp
     * @return
    完成了与 XML 配置及映射文件相关的讨论。下一章将详细探讨 Java API，以便你能充分利用已经创建的映射配置     */
    int update(Emp emp);

    /**
     * 删除员工
     *
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 查询员工所有记录
     *
     * @return
     */
    int count();
}
