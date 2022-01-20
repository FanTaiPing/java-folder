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
package me.zhengjie.workinfo.service.dto;

import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @website https://el-admin.vip
* @description /
* @author GaoJingBo
* @date 2021-09-27
**/
@Data
public class TbWorkInfoDto implements Serializable {

    /** 记录id */
    private Integer tbWorkInfoId;

    /** 记录内容 */
    private String infoDesc;

    /** 完成进度 */
    private Integer proess;

    /** 任务id */
    private Integer workId;

    /** 备注 */
    private String comment;

    /** 任务名称 */
    private String workName;

    /** 提交时间 */
    private Timestamp takeTime;

    /** 提交状态 */
    private String state;
}