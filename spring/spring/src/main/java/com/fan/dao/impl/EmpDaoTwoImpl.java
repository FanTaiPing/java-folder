package com.fan.dao.impl;

import com.fan.dao.EmpDao;

public class EmpDaoTwoImpl implements EmpDao {
    @Override
    public String getEmpById(int id) {
        return "EmpDao第二个实现类：id是"+ id + "的用户是：xxx";
    }
}
