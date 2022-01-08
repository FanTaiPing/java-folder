package com.km.sglototo.sys.vo;


import com.km.sglototo.sys.entity.SysArea;

import java.util.List;

/**
 *  2018/5/25.
 */
public class AreaWithChildrenItem extends SysArea {
    private List<SysArea> children;

    public List<SysArea> getChildren() {
        return children;
    }

    public void setChildren(List<SysArea> children) {
        this.children = children;
    }
}
