package com.louis.springboot.demo.dao;

import java.util.List;
import java.util.Map;

import com.louis.springboot.demo.model.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);
    

    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 查询全部用户
     * @return
     */
    List<Map<String,Object>> selectAllMap();
    
    /**
     * 分页查询用户
     * @return
     */
    List<SysUser> selectPage();
}