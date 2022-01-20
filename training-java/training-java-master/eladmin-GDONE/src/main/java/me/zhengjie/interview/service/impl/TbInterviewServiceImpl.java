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
package me.zhengjie.interview.service.impl;

import me.zhengjie.interview.domain.TbInterview;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.interview.repository.TbInterviewRepository;
import me.zhengjie.interview.service.TbInterviewService;
import me.zhengjie.interview.service.dto.TbInterviewDto;
import me.zhengjie.interview.service.dto.TbInterviewQueryCriteria;
import me.zhengjie.interview.service.mapstruct.TbInterviewMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.zhengjie.utils.PageUtil;
import me.zhengjie.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @website https://el-admin.vip
* @description 服务实现
* @author GaoJingBo
* @date 2021-09-30
**/
@Service
@RequiredArgsConstructor
public class TbInterviewServiceImpl implements TbInterviewService {

    private final TbInterviewRepository tbInterviewRepository;
    private final TbInterviewMapper tbInterviewMapper;

    @Override
    public Map<String,Object> queryAll(TbInterviewQueryCriteria criteria, Pageable pageable){
        Page<TbInterview> page = tbInterviewRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbInterviewMapper::toDto));
    }

    @Override
    public List<TbInterviewDto> queryAll(TbInterviewQueryCriteria criteria){
        return tbInterviewMapper.toDto(tbInterviewRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TbInterviewDto findById(Integer infoId) {
        TbInterview tbInterview = tbInterviewRepository.findById(infoId).orElseGet(TbInterview::new);
        ValidationUtil.isNull(tbInterview.getInfoId(),"TbInterview","infoId",infoId);
        return tbInterviewMapper.toDto(tbInterview);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbInterviewDto create(TbInterview resources) {
        return tbInterviewMapper.toDto(tbInterviewRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbInterview resources) {
        TbInterview tbInterview = tbInterviewRepository.findById(resources.getInfoId()).orElseGet(TbInterview::new);
        ValidationUtil.isNull( tbInterview.getInfoId(),"TbInterview","id",resources.getInfoId());
        tbInterview.copy(resources);
        tbInterviewRepository.save(tbInterview);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer infoId : ids) {
            tbInterviewRepository.deleteById(infoId);
        }
    }

    @Override
    public void download(List<TbInterviewDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TbInterviewDto tbInterview : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("公司名称", tbInterview.getName());
            map.put("公司位置", tbInterview.getAddress());
            map.put("公司类型", tbInterview.getCompanyType());
            map.put("面邀途径", tbInterview.getInterviewChannel());
            map.put("面邀平台", tbInterview.getInterviewPlatform());
            map.put("岗位类型", tbInterview.getPostType());
            map.put("面试岗位", tbInterview.getPostName());
            map.put("面试时间", tbInterview.getInterviewTime());
            map.put("岗位要求补充", tbInterview.getPostNeed());
            map.put("岗位设定薪资", tbInterview.getPostSalary());
            map.put("公司联系人", tbInterview.getCompanyStaff());
            map.put("联系人岗位", tbInterview.getCompanyStaffPost());
            map.put("联系人电话", tbInterview.getCompanyStaffTell());
            map.put("联系人微信", tbInterview.getCompanyStaffWx());
            map.put("联系人QQ", tbInterview.getCompanyStaffQq());
            map.put("面试结果", tbInterview.getResult());
            map.put("结果描述", tbInterview.getResultDesc());
            map.put("面试感想", tbInterview.getFeeling());
            map.put("是否一面", tbInterview.getIsFrist());
            map.put("是否进入下轮", tbInterview.getIsNext());
            map.put("是否录用", tbInterview.getIsLy());
            map.put("第几次面试此公司", tbInterview.getInterviewTimes());
            map.put("问题1", tbInterview.getQ1());
            map.put("回答1", tbInterview.getA1());
            map.put("问题2", tbInterview.getQ2());
            map.put("回答2", tbInterview.getA2());
            map.put("问题3", tbInterview.getQ3());
            map.put("回答3", tbInterview.getA3());
            map.put("问题4", tbInterview.getQ4());
            map.put("回答4", tbInterview.getA4());
            map.put("问题5", tbInterview.getQ5());
            map.put("回答5", tbInterview.getA5());
            map.put("问题6", tbInterview.getQ6());
            map.put("回答6", tbInterview.getA6());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}