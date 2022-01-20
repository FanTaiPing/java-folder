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
package me.zhengjie.teacher.domain;

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
* @date 2021-09-23
**/
@Entity
@Data
@Table(name="tb_teacher")
public class TbTeacher implements Serializable {

    @Id
    @Column(name = "teacher_id")
    @ApiModelProperty(value = "教师ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    @Column(name = "name")
    @ApiModelProperty(value = "姓名")
    private String name;

    @Column(name = "sex")
    @ApiModelProperty(value = "性别")
    private String sex;

    @Column(name = "age")
    @ApiModelProperty(value = "年龄")
    private Integer age;

    @Column(name = "education")
    @ApiModelProperty(value = "学历")
    private String education;

    @Column(name = "education_major")
    @ApiModelProperty(value = "学历专业")
    private String educationMajor;

    @Column(name = "teach_major")
    @ApiModelProperty(value = "教授专业")
    private String teachMajor;

    @Column(name = "technical_title")
    @ApiModelProperty(value = "职称")
    private String technicalTitle;

    @Column(name = "postName")
    @ApiModelProperty(value = "岗位")
    private String postname;

    @Column(name = "position_nature")
    @ApiModelProperty(value = "岗位类型")
    private String positionNature;

    @Column(name = "tel_number")
    @ApiModelProperty(value = "电话")
    private String telNumber;

    @Column(name = "qq_number")
    @ApiModelProperty(value = "QQ")
    private String qqNumber;

    @Column(name = "wx_number")
    @ApiModelProperty(value = "微信")
    private String wxNumber;

    @Column(name = "jobweek_start")
    @ApiModelProperty(value = "周工作日（起）")
    private String jobweekStart;

    @Column(name = "jobweek_end")
    @ApiModelProperty(value = "周工作日（止）")
    private String jobweekEnd;

    @Column(name = "entry_time")
    @ApiModelProperty(value = "入司时间")
    private Timestamp entryTime;

    public void copy(TbTeacher source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}