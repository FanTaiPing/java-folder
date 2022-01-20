package me.zhengjie.modules.train.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zhaox
 * @Date 22/1/19
 */
@Data
@TableName("tb_interview")
public class Interview implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "info_id", type = IdType.AUTO)
    private Integer infoId;

    private String name;

}
