package com.louis.springboot.demo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * cra_person
 * @author 
 */
public class CraPerson implements Serializable {
    private Integer id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 投资意向
     */
    private String tzyx;

    /**
     * 保存时间
     */
    private Date saveDatetime;

    /**
     * 受理状态 1 已受理，0待受理
     */
    private Integer slzt;

    /**
     * 处理意见
     */
    private String clyj;

    /**
     * 修改时间
     */
    private Date modifyDatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTzyx() {
        return tzyx;
    }

    public void setTzyx(String tzyx) {
        this.tzyx = tzyx;
    }

    public Date getSaveDatetime() {
        return saveDatetime;
    }

    public void setSaveDatetime(Date saveDatetime) {
        this.saveDatetime = saveDatetime;
    }

    public Integer getSlzt() {
        return slzt;
    }

    public void setSlzt(Integer slzt) {
        this.slzt = slzt;
    }

    public String getClyj() {
        return clyj;
    }

    public void setClyj(String clyj) {
        this.clyj = clyj;
    }

    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CraPerson other = (CraPerson) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getTzyx() == null ? other.getTzyx() == null : this.getTzyx().equals(other.getTzyx()))
            && (this.getSaveDatetime() == null ? other.getSaveDatetime() == null : this.getSaveDatetime().equals(other.getSaveDatetime()))
            && (this.getSlzt() == null ? other.getSlzt() == null : this.getSlzt().equals(other.getSlzt()))
            && (this.getClyj() == null ? other.getClyj() == null : this.getClyj().equals(other.getClyj()))
            && (this.getModifyDatetime() == null ? other.getModifyDatetime() == null : this.getModifyDatetime().equals(other.getModifyDatetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getTzyx() == null) ? 0 : getTzyx().hashCode());
        result = prime * result + ((getSaveDatetime() == null) ? 0 : getSaveDatetime().hashCode());
        result = prime * result + ((getSlzt() == null) ? 0 : getSlzt().hashCode());
        result = prime * result + ((getClyj() == null) ? 0 : getClyj().hashCode());
        result = prime * result + ((getModifyDatetime() == null) ? 0 : getModifyDatetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mobile=").append(mobile);
        sb.append(", tzyx=").append(tzyx);
        sb.append(", saveDatetime=").append(saveDatetime);
        sb.append(", slzt=").append(slzt);
        sb.append(", clyj=").append(clyj);
        sb.append(", modifyDatetime=").append(modifyDatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}