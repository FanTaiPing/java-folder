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
package me.zhengjie.work.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-26
**/
@Entity
@Data
@Table(name="tb_work")
public class TbWork implements Serializable {

    @Column(name = "name")
    @ApiModelProperty(value = "任务名称")
    private String name;

    @Column(name = "proess")
    @ApiModelProperty(value = "完成进度")
    private Integer proess;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id")
    @ApiModelProperty(value = "任务id")
    private Integer workId;

    @Column(name = "work_code")
    @ApiModelProperty(value = "任务code")
    private String workCode;

    @Column(name = "work_desc")
    @ApiModelProperty(value = "任务描述")
    private String workDesc;

    @Column(name = "cr_teacher_id")
    @ApiModelProperty(value = "创建老师id")
    private Integer crTeacherId;

    @Column(name = "cr_teacher_name")
    @ApiModelProperty(value = "审查教师")
    private String crTeacherName;

    @Column(name = "cr_class_id")
    @ApiModelProperty(value = "对应班级id")
    private Integer crClassId;

    @Column(name = "cr_student_id")
    @ApiModelProperty(value = "对应学生id")
    private Integer crStudentId;

    @Column(name = "work_state")
    @ApiModelProperty(value = "任务状态")
    private Integer workState;

    @Column(name = "cr_class_name")
    @ApiModelProperty(value = "对应班级名称")
    private String crClassName;

    @Column(name = "cr_student_name")
    @ApiModelProperty(value = "对应学生名称")
    private String crStudentName;

    public void copy(TbWork source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}