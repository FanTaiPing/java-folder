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
package me.zhengjie.classManager.service.impl;

import me.zhengjie.classManager.domain.TbClass;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.classManager.repository.TbClassRepository;
import me.zhengjie.classManager.service.TbClassService;
import me.zhengjie.classManager.service.dto.TbClassDto;
import me.zhengjie.classManager.service.dto.TbClassQueryCriteria;
import me.zhengjie.classManager.service.mapstruct.TbClassMapper;
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
* @date 2021-09-18
**/
@Service
@RequiredArgsConstructor
public class TbClassServiceImpl implements TbClassService {

    private final TbClassRepository tbClassRepository;
    private final TbClassMapper tbClassMapper;

    @Override
    public Map<String,Object> queryAll(TbClassQueryCriteria criteria, Pageable pageable){
        Page<TbClass> page = tbClassRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbClassMapper::toDto));
    }

    @Override
    public List<TbClassDto> queryAll(TbClassQueryCriteria criteria){
        return tbClassMapper.toDto(tbClassRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TbClassDto findById(Integer classId) {
        TbClass tbClass = tbClassRepository.findById(classId).orElseGet(TbClass::new);
        ValidationUtil.isNull(tbClass.getClassId(),"TbClass","classId",classId);
        return tbClassMapper.toDto(tbClass);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbClassDto create(TbClass resources) {
        return tbClassMapper.toDto(tbClassRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbClass resources) {
        TbClass tbClass = tbClassRepository.findById(resources.getClassId()).orElseGet(TbClass::new);
        ValidationUtil.isNull( tbClass.getClassId(),"TbClass","id",resources.getClassId());
        tbClass.copy(resources);
        tbClassRepository.save(tbClass);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer classId : ids) {
            tbClassRepository.deleteById(classId);
        }
    }

    @Override
    public void download(List<TbClassDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TbClassDto tbClass : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("班级编号", tbClass.getCode());
            map.put("班级名称", tbClass.getName());
            map.put("开班时间", tbClass.getClassStart());
            map.put("预计结课时间", tbClass.getClassEnd());
            map.put("班级类型", tbClass.getType());
            map.put(" mTeacherId",  tbClass.getMTeacherId());
            map.put("班主任", tbClass.getMTeacherName());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}