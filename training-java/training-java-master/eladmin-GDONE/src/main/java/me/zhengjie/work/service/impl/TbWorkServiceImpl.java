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
package me.zhengjie.work.service.impl;

import me.zhengjie.work.domain.TbWork;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.work.repository.TbWorkRepository;
import me.zhengjie.work.service.TbWorkService;
import me.zhengjie.work.service.dto.TbWorkDto;
import me.zhengjie.work.service.dto.TbWorkQueryCriteria;
import me.zhengjie.work.service.mapstruct.TbWorkMapper;
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
* @date 2021-09-26
**/
@Service
@RequiredArgsConstructor
public class TbWorkServiceImpl implements TbWorkService {

    private final TbWorkRepository tbWorkRepository;
    private final TbWorkMapper tbWorkMapper;

    @Override
    public Map<String,Object> queryAll(TbWorkQueryCriteria criteria, Pageable pageable){
        Page<TbWork> page = tbWorkRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbWorkMapper::toDto));
    }

    @Override
    public List<TbWorkDto> queryAll(TbWorkQueryCriteria criteria){
        return tbWorkMapper.toDto(tbWorkRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TbWorkDto findById(Integer workId) {
        TbWork tbWork = tbWorkRepository.findById(workId).orElseGet(TbWork::new);
        ValidationUtil.isNull(tbWork.getWorkId(),"TbWork","workId",workId);
        return tbWorkMapper.toDto(tbWork);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbWorkDto create(TbWork resources) {
        return tbWorkMapper.toDto(tbWorkRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbWork resources) {
        TbWork tbWork = tbWorkRepository.findById(resources.getWorkId()).orElseGet(TbWork::new);
        ValidationUtil.isNull( tbWork.getWorkId(),"TbWork","id",resources.getWorkId());
        tbWork.copy(resources);
        tbWorkRepository.save(tbWork);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer workId : ids) {
            tbWorkRepository.deleteById(workId);
        }
    }

    @Override
    public void download(List<TbWorkDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TbWorkDto tbWork : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("任务名称", tbWork.getName());
            map.put("完成进度", tbWork.getProess());
            map.put("任务code", tbWork.getWorkCode());
            map.put("任务描述", tbWork.getWorkDesc());
            map.put("创建老师id", tbWork.getCrTeacherId());
            map.put("审查教师", tbWork.getCrTeacherName());
            map.put("对应班级id", tbWork.getCrClassId());
            map.put("对应学生id", tbWork.getCrStudentId());
            map.put("任务状态", tbWork.getWorkState());
            map.put("对应班级名称", tbWork.getCrClassName());
            map.put("对应学生名称", tbWork.getCrStudentName());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}