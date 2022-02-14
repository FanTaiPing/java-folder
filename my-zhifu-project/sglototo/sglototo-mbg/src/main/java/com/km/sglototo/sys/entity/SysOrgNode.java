package com.km.sglototo.sys.entity;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 *
 */
public class SysOrgNode extends SysOrg {


    @Getter
    @Setter
    private List<SysOrgNode> children;

    private String label;

    public String getLabel() {
        return this.getName();
    }

    public void setLabel(String label) {
        this.setName(this.getName());
    }
}
