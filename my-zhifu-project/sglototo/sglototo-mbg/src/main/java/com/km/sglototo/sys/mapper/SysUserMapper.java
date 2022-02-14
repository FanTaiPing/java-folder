package com.km.sglototo.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.km.sglototo.sys.entity.SysUser;
import com.km.sglototo.sys.entity.SysUserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台用户表 Mapper 接口
 * </p>
 *
 * 
 * @since 2019-04-14
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    SysUserVo selectByUserName(String username);

    /**
     * 查询所有系统用户信息
     * @return
     */
    List<SysUser> findAllSysUser(Map map);
    /**
     * 查询所有系统用户信息
     * @return
     */
    List<SysUser> findAllSysUser();
    /**
     * 根据id删除用户信息
     * @param id
     * @return
     */
    int deleteUser(int id);
    /**
     *添加用户信息
     * @param sysUser
     * @return
     */
    int insertUser(SysUser sysUser);
}
