package com.fan.service.impl;

import com.fan.dao.EmpDao;
import com.fan.entity.Emp;
import com.fan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author y
 * @Service 告诉他是实现类的组件
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public List<Emp> findAll() {
        return empDao.findAll();
    }

    @Override
    public void insertEmp(Emp emp) {
        empDao.insertEmp(emp);
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
    public int deleteEmp(Emp emp) {
        return empDao.deleteEmp(emp);
    }
}
