package com.km.sglototo.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.km.sglototo.build.entity.UserCommunityRelate;
import com.km.sglototo.sys.entity.SysPermission;
import com.km.sglototo.sys.entity.SysRole;
import com.km.sglototo.sys.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 后台用户表 服务类
 * </p>
 *
 * @author zscat
 * @since 2019-04-14
 */
public interface ISysUserService extends IService<SysUser> {

    String refreshToken(String token);

    String login(String username, String password);

    int updateUserRole(Long adminId, List<Long> roleIds);

    List<SysRole> getRoleListByUserId(Long adminId);

    int updatePermissionByUserId(Long adminId, List<Long> permissionIds);

    List<SysPermission> getPermissionListByUserId(Long adminId);

    List<SysPermission> listMenuByUserId(Long adminId);

    boolean saves(SysUser entity);

    boolean updates(Long id, SysUser admin);

    List<SysPermission> listUserPerms(Long id);

    void removePermissRedis(Long id);

    List<SysPermission> listPerms();

    Object reg(SysUser entity);

//    SmsCode generateCode(String phone);

    int updateShowStatus(List<Long> ids, Integer showStatus);

    Object userCommunityRelate(UserCommunityRelate entity);

    void updatePassword(String password, String newPassword);

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
