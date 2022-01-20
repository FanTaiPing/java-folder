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
package me.zhengjie.work.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-26
**/
@Data
public class TbWorkDto implements Serializable {

    /** 任务名称 */
    private String name;

    /** 完成进度 */
    private Integer proess;

    /** 任务id */
    private Integer workId;

    /** 任务code */
    private String workCode;

    /** 任务描述 */
    private String workDesc;

    /** 创建老师id */
    private Integer crTeacherId;

    /** 审查教师 */
    private String crTeacherName;

    /** 对应班级id */
    private Integer crClassId;

    /** 对应学生id */
    private Integer crStudentId;

    /** 任务状态 */
    private Integer workState;

    /** 对应班级名称 */
    private String crClassName;

    /** 对应学生名称 */
    private String crStudentName;
}