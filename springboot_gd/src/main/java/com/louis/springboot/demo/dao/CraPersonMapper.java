package com.louis.springboot.demo.dao;

import com.louis.springboot.demo.model.CraPerson;
import com.louis.springboot.demo.model.CraPersonExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface CraPersonMapper {
    long countByExample(CraPersonExample example);

    int deleteByExample(CraPersonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CraPerson record);

    int insertSelective(CraPerson record);

    List<CraPerson> selectByExample(CraPersonExample example);

    CraPerson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CraPerson record, @Param("example") CraPersonExample example);

    int updateByExample(@Param("record") CraPerson record, @Param("example") CraPersonExample example);

    int updateByPrimaryKeySelective(CraPerson record);

    int updateByPrimaryKey(CraPerson record);



    /**
     * 查询全部
     * @return
     */
    List<Map<String,Object>> selectAllMap(Map<String,String> param);



}