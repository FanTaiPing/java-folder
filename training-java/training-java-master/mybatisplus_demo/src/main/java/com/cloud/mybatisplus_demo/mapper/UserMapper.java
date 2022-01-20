package com.cloud.mybatisplus_demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.mybatisplus_demo.bean.SysUser;

import java.util.List;


public interface UserMapper extends BaseMapper<SysUser> {

    public List<SysUser> findAllUser();
}
