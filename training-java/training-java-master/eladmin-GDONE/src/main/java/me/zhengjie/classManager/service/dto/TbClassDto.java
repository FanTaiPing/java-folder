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
package me.zhengjie.classManager.service.dto;

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
public class TbClassDto implements Serializable {

    /** 班级id */
    private Integer classId;

    /** 班级编号 */
    private String code;

    /** 班级名称 */
    private String name;

    /** 开班时间 */
    private Timestamp classStart;

    /** 预计结课时间 */
    private Timestamp classEnd;

    /** 班级类型 */
    private String type;

    private Integer mTeacherId;

    /** 班主任 */
    private String mTeacherName;
}