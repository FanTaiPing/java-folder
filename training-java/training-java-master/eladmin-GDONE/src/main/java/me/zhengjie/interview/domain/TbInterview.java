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
package me.zhengjie.interview.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.ApiModelProperty;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-30
**/
@Entity
@Data
@Table(name="tb_interview")
public class TbInterview implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "info_id")
    @ApiModelProperty(value = "记录id")
    private Integer infoId;

    @Column(name = "name")
    @ApiModelProperty(value = "公司名称")
    private String name;

    @Column(name = "address")
    @ApiModelProperty(value = "公司位置")
    private String address;

    @Column(name = "company_type")
    @ApiModelProperty(value = "公司类型")
    private String companyType;

    @Column(name = "interview_channel")
    @ApiModelProperty(value = "面邀途径")
    private String interviewChannel;

    @Column(name = "interview_platform")
    @ApiModelProperty(value = "面邀平台")
    private String interviewPlatform;

    @Column(name = "post_type")
    @ApiModelProperty(value = "岗位类型")
    private String postType;

    @Column(name = "post_name")
    @ApiModelProperty(value = "面试岗位")
    private String postName;

    @Column(name = "interview_time")
    @ApiModelProperty(value = "面试时间")
    private Timestamp interviewTime;

    @Column(name = "post_need")
    @ApiModelProperty(value = "岗位要求补充")
    private String postNeed;

    @Column(name = "post_salary")
    @ApiModelProperty(value = "岗位设定薪资")
    private BigDecimal postSalary;

    @Column(name = "company_staff")
    @ApiModelProperty(value = "公司联系人")
    private String companyStaff;

    @Column(name = "company_staff_post")
    @ApiModelProperty(value = "联系人岗位")
    private String companyStaffPost;

    @Column(name = "company_staff_tell")
    @ApiModelProperty(value = "联系人电话")
    private String companyStaffTell;

    @Column(name = "company_staff_wx")
    @ApiModelProperty(value = "联系人微信")
    private String companyStaffWx;

    @Column(name = "company_staff_qq")
    @ApiModelProperty(value = "联系人QQ")
    private String companyStaffQq;

    @Column(name = "result")
    @ApiModelProperty(value = "面试结果")
    private String result;

    @Column(name = "result_desc")
    @ApiModelProperty(value = "结果描述")
    private String resultDesc;

    @Column(name = "feeling")
    @ApiModelProperty(value = "面试感想")
    private String feeling;

    @Column(name = "is_frist")
    @ApiModelProperty(value = "是否一面")
    private String isFrist;

    @Column(name = "is_next")
    @ApiModelProperty(value = "是否进入下轮")
    private String isNext;

    @Column(name = "is_ly")
    @ApiModelProperty(value = "是否录用")
    private String isLy;

    @Column(name = "interview_times")
    @ApiModelProperty(value = "第几次面试此公司")
    private Integer interviewTimes;

    @Column(name = "q1")
    @ApiModelProperty(value = "问题1")
    private String q1;

    @Column(name = "a1")
    @ApiModelProperty(value = "回答1")
    private String a1;

    @Column(name = "q2")
    @ApiModelProperty(value = "问题2")
    private String q2;

    @Column(name = "a2")
    @ApiModelProperty(value = "回答2")
    private String a2;

    @Column(name = "q3")
    @ApiModelProperty(value = "问题3")
    private String q3;

    @Column(name = "a3")
    @ApiModelProperty(value = "回答3")
    private String a3;

    @Column(name = "q4")
    @ApiModelProperty(value = "问题4")
    private String q4;

    @Column(name = "a4")
    @ApiModelProperty(value = "回答4")
    private String a4;

    @Column(name = "q5")
    @ApiModelProperty(value = "问题5")
    private String q5;

    @Column(name = "a5")
    @ApiModelProperty(value = "回答5")
    private String a5;

    @Column(name = "q6")
    @ApiModelProperty(value = "问题6")
    private String q6;

    @Column(name = "a6")
    @ApiModelProperty(value = "回答6")
    private String a6;

    public void copy(TbInterview source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}