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
package me.zhengjie.interview.service;

import me.zhengjie.interview.domain.TbInterview;
import me.zhengjie.interview.service.dto.TbInterviewDto;
import me.zhengjie.interview.service.dto.TbInterviewQueryCriteria;
import org.springframework.data.domain.Pageable;
import java.util.Map;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @website https://el-admin.vip
* @description 服务接口
* @author GaoJingBo
* @date 2021-09-30
**/
public interface TbInterviewService {

    /**
    * 查询数据分页
    * @param criteria 条件
    * @param pageable 分页参数
    * @return Map<String,Object>
    */
    Map<String,Object> queryAll(TbInterviewQueryCriteria criteria, Pageable pageable);

    /**
    * 查询所有数据不分页
    * @param criteria 条件参数
    * @return List<TbInterviewDto>
    */
    List<TbInterviewDto> queryAll(TbInterviewQueryCriteria criteria);

    /**
     * 根据ID查询
     * @param infoId ID
     * @return TbInterviewDto
     */
    TbInterviewDto findById(Integer infoId);

    /**
    * 创建
    * @param resources /
    * @return TbInterviewDto
    */
    TbInterviewDto create(TbInterview resources);

    /**
    * 编辑
    * @param resources /
    */
    void update(TbInterview resources);

    /**
    * 多选删除
    * @param ids /
    */
    void deleteAll(Integer[] ids);

    /**
    * 导出数据
    * @param all 待导出的数据
    * @param response /
    * @throws IOException /
    */
    void download(List<TbInterviewDto> all, HttpServletResponse response) throws IOException;
}