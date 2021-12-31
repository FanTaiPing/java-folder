package com.fan.service.impl;

import com.fan.dao.EmpDao;
import com.fan.entity.Emp;
import com.fan.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> empFindAll() {
        return empDao.empFindAll();
    }

    @Override
    public Emp getEmpById(int id) {
        return empDao.getEmpById(id);
    }

    @Override
    public int addEmp(Emp emp) {
        return empDao.addEmp(emp);
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
