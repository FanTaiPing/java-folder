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
package me.zhengjie.interview.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-30
**/
@Data
public class TbInterviewDto implements Serializable {

    /** 记录id */
    private Integer infoId;

    /** 公司名称 */
    private String name;

    /** 公司位置 */
    private String address;

    /** 公司类型 */
    private String companyType;

    /** 面邀途径 */
    private String interviewChannel;

    /** 面邀平台 */
    private String interviewPlatform;

    /** 岗位类型 */
    private String postType;

    /** 面试岗位 */
    private String postName;

    /** 面试时间 */
    private Timestamp interviewTime;

    /** 岗位要求补充 */
    private String postNeed;

    /** 岗位设定薪资 */
    private BigDecimal postSalary;

    /** 公司联系人 */
    private String companyStaff;

    /** 联系人岗位 */
    private String companyStaffPost;

    /** 联系人电话 */
    private String companyStaffTell;

    /** 联系人微信 */
    private String companyStaffWx;

    /** 联系人QQ */
    private String companyStaffQq;

    /** 面试结果 */
    private String result;

    /** 结果描述 */
    private String resultDesc;

    /** 面试感想 */
    private String feeling;

    /** 是否一面 */
    private String isFrist;

    /** 是否进入下轮 */
    private String isNext;

    /** 是否录用 */
    private String isLy;

    /** 第几次面试此公司 */
    private Integer interviewTimes;

    /** 问题1 */
    private String q1;

    /** 回答1 */
    private String a1;

    /** 问题2 */
    private String q2;

    /** 回答2 */
    private String a2;

    /** 问题3 */
    private String q3;

    /** 回答3 */
    private String a3;

    /** 问题4 */
    private String q4;

    /** 回答4 */
    private String a4;

    /** 问题5 */
    private String q5;

    /** 回答5 */
    private String a5;

    /** 问题6 */
    private String q6;

    /** 回答6 */
    private String a6;
}