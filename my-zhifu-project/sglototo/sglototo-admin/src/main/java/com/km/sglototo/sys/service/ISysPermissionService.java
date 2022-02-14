package com.km.sglototo.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.km.sglototo.bo.Tree;
import com.km.sglototo.sys.entity.SysPermission;
import com.km.sglototo.sys.entity.SysPermissionNode;

import java.util.List;

/**
 * <p>
 * 后台用户权限表 服务类
 * </p>
 *
 * 
 * @since 2019-04-14
 */
public interface ISysPermissionService extends IService<SysPermission> {

    List<Tree<SysPermission>> getPermissionsByUserId(Long id);

    List<SysPermissionNode> treeList();

    List<Tree<SysPermission>> getAllPermission();
}
