package com.cloud.mybatisplus_demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.mybatisplus_demo.bean.SysUser;
import com.cloud.mybatisplus_demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, SysUser> implements IUserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public List<SysUser> findAllUser() {
        return userMapper.findAllUser();
    }
}