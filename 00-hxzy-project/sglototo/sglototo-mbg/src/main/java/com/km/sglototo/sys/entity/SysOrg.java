package com.km.sglototo.sys.entity;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import java.io.Serializable;

/**
 * 组织机构
 * @author xt
 * @date 2021-02-25
 */
@Data
@TableName("sys_org")
public class SysOrg implements Serializable {




    @TableId(value = "id", type = IdType.INPUT)
    private String id;


    @TableField( "pid")
    private String pid;


    @TableField("deep")
    private Integer deep;


    @TableField("name")
    private String name;


    @TableField("pinyin_prefix")
    private String pinyinPrefix;


    @TableField("pinyin")
    private String pinyin;


    @TableField("ext_id")
    private String extId;


    @TableField("ext_name")
    private String extName;


    @TableField("organize_id")
    private Integer organizeId;


    @TableField("create_time")
    private Date createTime;



}
