package com.km.sglototo.utils;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Auther:
 * @Date: 2019/5/19 02:16
 * @Description:
 */
@Setter
@Getter
public class BaseEntity implements Serializable {
    @TableField("store_id")
    private Integer storeId;
}
