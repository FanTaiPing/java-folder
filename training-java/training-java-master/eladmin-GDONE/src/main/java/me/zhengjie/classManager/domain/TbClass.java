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
package me.zhengjie.classManager.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-18
**/
@Entity
@Data
@Table(name="tb_class")
public class TbClass implements Serializable {

    @Id
    @Column(name = "class_id")
    @ApiModelProperty(value = "班级id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classId;

    @Column(name = "code")
    @ApiModelProperty(value = "班级编号")
    private String code;

    @Column(name = "name")
    @ApiModelProperty(value = "班级名称")
    private String name;

    @Column(name = "class_start")
    @ApiModelProperty(value = "开班时间")
    private Timestamp classStart;

    @Column(name = "class_end")
    @ApiModelProperty(value = "预计结课时间")
    private Timestamp classEnd;

    @Column(name = "type")
    @ApiModelProperty(value = "班级类型")
    private String type;

    @Column(name = "m_teacher_id")
    @ApiModelProperty(value = "mTeacherId")
    private Integer mTeacherId;

    @Column(name = "m_teacher_name")
    @ApiModelProperty(value = "班主任")
    private String mTeacherName;

    public void copy(TbClass source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}