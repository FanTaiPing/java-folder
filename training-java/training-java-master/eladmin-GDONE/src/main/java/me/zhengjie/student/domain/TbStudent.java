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
package me.zhengjie.student.domain;

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
@Table(name="tb_student")
public class TbStudent implements Serializable {

    @Id
    @Column(name = "st_id")
    @ApiModelProperty(value = "学生id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stId;

    @Column(name = "class_id")
    @ApiModelProperty(value = "班级id")
    private Integer classId;

    @Column(name = "name",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "姓名")
    private String name;

    @Column(name = "lean_time",nullable = false)
    @NotNull
    @ApiModelProperty(value = "入学时间")
    private Timestamp leanTime;

    @Column(name = "sex",nullable = false)
    @NotBlank
    @ApiModelProperty(value = "性别")
    private String sex;

    @Column(name = "birthday",nullable = false)
    @NotNull
    @ApiModelProperty(value = "生日")
    private Timestamp birthday;

    @Column(name = "native_place")
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;

    @Column(name = "education")
    @ApiModelProperty(value = "学历")
    private String education;

    @Column(name = "graduation_school")
    @ApiModelProperty(value = "毕业院校")
    private String graduationSchool;

    @Column(name = "major")
    @ApiModelProperty(value = "专业")
    private String major;

    @Column(name = "idcode")
    @ApiModelProperty(value = "身份证号码")
    private String idcode;

    @Column(name = "tel_number")
    @ApiModelProperty(value = "手机号码")
    private String telNumber;

    @Column(name = "qq_number")
    @ApiModelProperty(value = "QQ")
    private String qqNumber;

    @Column(name = "wx_number")
    @ApiModelProperty(value = "微信")
    private String wxNumber;

    @Column(name = "jt_address")
    @ApiModelProperty(value = "家庭住址")
    private String jtAddress;

    @Column(name = "now_address")
    @ApiModelProperty(value = "现居住地址")
    private String nowAddress;

    @Column(name = "self_context")
    @ApiModelProperty(value = "自我介绍")
    private String selfContext;

    @Column(name = "photo_id")
    @ApiModelProperty(value = "学生照片id")
    private String photoId;

    public void copy(TbStudent source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}