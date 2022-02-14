package com.km.sglototo.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.km.sglototo.utils.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * <p>
 * </p>
 *
 * 
 * @since 2019-04-14
 */
@Data
@TableName("sys_area")
public class SysArea  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long pid;

    /**
     * 层级
     */
    private Integer deep;

    /**
     * 名称
     */
    private String name;

    /**
     * 拼音前缀
     */
    @TableField("pinyin_prefix")
    private String pinyinPrefix;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 备注名
     */
    @TableField("ext_id")
    private String extId;



    /**
     * 备注名
     */
    @TableField("ext_name")
    private String extName;

    @TableField(exist = false)
    private List<SysArea> children = new ArrayList<>();

}
