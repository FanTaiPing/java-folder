package com.fan.service.impl;

import com.fan.dao.EmpDao;
import com.fan.entity.Emp;
import com.fan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    //注入EmpDao接口
    @Autowired
    private EmpDao empDao;

    /**
     * 查询所有员工的信息
     * @return
     */
    @Override
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void addEmp(Emp emp) {
       empDao.addEmp(emp);
    }

    @Override
    public Emp getById(int id) {
        return empDao.getById(id);
    }

    @Override
    public int updateEmp(Emp emp) {
        return empDao.updateEmp(emp);
    }

    @Override
    public int deleteEmp(int id) {
        return empDao.deleteEmp(id);
    }
}
