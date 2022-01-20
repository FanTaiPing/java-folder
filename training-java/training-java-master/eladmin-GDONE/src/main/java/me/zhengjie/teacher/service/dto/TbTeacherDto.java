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
package me.zhengjie.teacher.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-23
**/
@Data
public class TbTeacherDto implements Serializable {

    /** 教师ID */
    private Integer teacherId;

    /** 姓名 */
    private String name;

    /** 性别 */
    private String sex;

    /** 年龄 */
    private Integer age;

    /** 学历 */
    private String education;

    /** 学历专业 */
    private String educationMajor;

    /** 教授专业 */
    private String teachMajor;

    /** 职称 */
    private String technicalTitle;

    /** 岗位 */
    private String postname;

    /** 岗位类型 */
    private String positionNature;

    /** 电话 */
    private String telNumber;

    /** QQ */
    private String qqNumber;

    /** 微信 */
    private String wxNumber;

    /** 周工作日（起） */
    private String jobweekStart;

    /** 周工作日（止） */
    private String jobweekEnd;

    /** 入司时间 */
    private Timestamp entryTime;
}