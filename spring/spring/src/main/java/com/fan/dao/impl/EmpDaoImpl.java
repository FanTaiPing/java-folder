package com.fan.dao.impl;

import com.fan.dao.EmpDao;

/**
 * @author y
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public String getEmpById(int id) {
        return "id是" + id + "的用户名称是：尼古拉斯赵四";
    }
}
