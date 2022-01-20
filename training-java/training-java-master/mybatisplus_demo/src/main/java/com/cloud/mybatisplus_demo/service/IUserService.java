package com.cloud.mybatisplus_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.mybatisplus_demo.bean.SysUser;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService extends IService<SysUser> {

    List<SysUser> findAllUser();
}
