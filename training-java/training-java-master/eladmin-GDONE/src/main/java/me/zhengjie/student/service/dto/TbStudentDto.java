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
package me.zhengjie.student.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-18
**/
@Data
public class TbStudentDto implements Serializable {

    /** 学生id */
    private Integer stId;

    /** 班级id */
    private Integer classId;

    /** 姓名 */
    private String name;

    /** 入学时间 */
    private Timestamp leanTime;

    /** 性别 */
    private String sex;

    /** 生日 */
    private Timestamp birthday;

    /** 籍贯 */
    private String nativePlace;

    /** 学历 */
    private String education;

    /** 毕业院校 */
    private String graduationSchool;

    /** 专业 */
    private String major;

    /** 身份证号码 */
    private String idcode;

    /** 手机号码 */
    private String telNumber;

    /** QQ */
    private String qqNumber;

    /** 微信 */
    private String wxNumber;

    /** 家庭住址 */
    private String jtAddress;

    /** 现居住地址 */
    private String nowAddress;

    /** 自我介绍 */
    private String selfContext;

    /** 学生照片id */
    private String photoId;
}