package com.louis.springboot.demo.service.impl;

import com.louis.springboot.demo.dao.CraPersonMapper;
import com.louis.springboot.demo.model.CraPerson;
import com.louis.springboot.demo.model.CraPersonExample;
import com.louis.springboot.demo.service.CarPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CarPersonServiceImpl implements CarPersonService {
    
    @Autowired
    private CraPersonMapper craPersonMapper;



    @Override
    public List<Map<String,Object>> findAllMap(Map<String,String> param) {
        return craPersonMapper.selectAllMap(param);
    }

//
//    @Override
//    public List<Map<String,Object>> findAllMap(Map<String,String> param) {
//        return craPersonMapper.selectAllByMobile();
//    }

    @Override
    public int updateByPrimaryKey(CraPerson p) {
        return craPersonMapper.updateByPrimaryKey(p);
    }

    @Override
    public int insert(CraPerson p) {
        return craPersonMapper.insert(p);
    }

    @Override
    public List<CraPerson> selectByExample(CraPersonExample example){
        return craPersonMapper.selectByExample(example);
    }


}