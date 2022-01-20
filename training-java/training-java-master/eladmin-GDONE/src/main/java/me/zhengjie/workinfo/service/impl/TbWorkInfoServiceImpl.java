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
package me.zhengjie.workinfo.service.impl;

import me.zhengjie.workinfo.domain.TbWorkInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.workinfo.repository.TbWorkInfoRepository;
import me.zhengjie.workinfo.service.TbWorkInfoService;
import me.zhengjie.workinfo.service.dto.TbWorkInfoDto;
import me.zhengjie.workinfo.service.dto.TbWorkInfoQueryCriteria;
import me.zhengjie.workinfo.service.mapstruct.TbWorkInfoMapper;
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
* @date 2021-09-27
**/
@Service
@RequiredArgsConstructor
public class TbWorkInfoServiceImpl implements TbWorkInfoService {

    private final TbWorkInfoRepository tbWorkInfoRepository;
    private final TbWorkInfoMapper tbWorkInfoMapper;

    @Override
    public Map<String,Object> queryAll(TbWorkInfoQueryCriteria criteria, Pageable pageable){
        Page<TbWorkInfo> page = tbWorkInfoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbWorkInfoMapper::toDto));
    }

    @Override
    public List<TbWorkInfoDto> queryAll(TbWorkInfoQueryCriteria criteria){
        return tbWorkInfoMapper.toDto(tbWorkInfoRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TbWorkInfoDto findById(Integer tbWorkInfoId) {
        TbWorkInfo tbWorkInfo = tbWorkInfoRepository.findById(tbWorkInfoId).orElseGet(TbWorkInfo::new);
        ValidationUtil.isNull(tbWorkInfo.getTbWorkInfoId(),"TbWorkInfo","tbWorkInfoId",tbWorkInfoId);
        return tbWorkInfoMapper.toDto(tbWorkInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbWorkInfoDto create(TbWorkInfo resources) {
        return tbWorkInfoMapper.toDto(tbWorkInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbWorkInfo resources) {
        TbWorkInfo tbWorkInfo = tbWorkInfoRepository.findById(resources.getTbWorkInfoId()).orElseGet(TbWorkInfo::new);
        ValidationUtil.isNull( tbWorkInfo.getTbWorkInfoId(),"TbWorkInfo","id",resources.getTbWorkInfoId());
        tbWorkInfo.copy(resources);
        tbWorkInfoRepository.save(tbWorkInfo);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer tbWorkInfoId : ids) {
            tbWorkInfoRepository.deleteById(tbWorkInfoId);
        }
    }

    @Override
    public void download(List<TbWorkInfoDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TbWorkInfoDto tbWorkInfo : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("记录内容", tbWorkInfo.getInfoDesc());
            map.put("完成进度", tbWorkInfo.getProess());
            map.put("任务id", tbWorkInfo.getWorkId());
            map.put("备注", tbWorkInfo.getComment());
            map.put("任务名称", tbWorkInfo.getWorkName());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}