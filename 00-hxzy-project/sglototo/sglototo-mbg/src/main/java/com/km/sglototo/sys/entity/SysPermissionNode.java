package com.km.sglototo.sys.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *  2018/9/30.
 */
public class SysPermissionNode extends SysPermission {
    @Getter
    @Setter
    private List<SysPermissionNode> children;
}
