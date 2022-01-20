/*
*  Copyright 2019-2020 Zheng Jie
*
*  Licensed under the Apache License, Version 2.0 (the "License");
*  you may not use this file except in compliance with the License.
*  You may obtain a copy of the License at
*
*  http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software
*  distributed under the License is distributed on an "AS IS" BASIS,
*  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
*  See the License for the specific language governing permissions and
*  limitations under the License.
*/
package me.zhengjie.workinfo.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-27
**/
@Entity
@Data
@Table(name="tb_work_info")
public class TbWorkInfo implements Serializable {

    @Id
    @Column(name = "tb_work_info_id")
    @ApiModelProperty(value = "记录id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tbWorkInfoId;

    @Column(name = "info_desc")
    @ApiModelProperty(value = "记录内容")
    private String infoDesc;

    @Column(name = "proess")
    @ApiModelProperty(value = "完成进度")
    private Integer proess;

    @Column(name = "work_id")
    @ApiModelProperty(value = "任务id")
    private Integer workId;

    @Column(name = "comment")
    @ApiModelProperty(value = "备注")
    private String comment;

    @Column(name = "work_name")
    @ApiModelProperty(value = "任务名称")
    private String workName;

    @Column(name = "take_time",nullable = false)
    @ApiModelProperty(value = "提交时间")
    private Timestamp takeTime;

    @Column(name = "state")
    @ApiModelProperty(value = "提交状态")
    private String state;

    public void copy(TbWorkInfo source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}