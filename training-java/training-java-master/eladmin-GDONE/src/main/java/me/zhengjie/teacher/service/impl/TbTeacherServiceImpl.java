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
package me.zhengjie.teacher.service.impl;

import me.zhengjie.teacher.domain.TbTeacher;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.teacher.repository.TbTeacherRepository;
import me.zhengjie.teacher.service.TbTeacherService;
import me.zhengjie.teacher.service.dto.TbTeacherDto;
import me.zhengjie.teacher.service.dto.TbTeacherQueryCriteria;
import me.zhengjie.teacher.service.mapstruct.TbTeacherMapper;
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
* @date 2021-09-23
**/
@Service
@RequiredArgsConstructor
public class TbTeacherServiceImpl implements TbTeacherService {

    private final TbTeacherRepository tbTeacherRepository;
    private final TbTeacherMapper tbTeacherMapper;

    @Override
    public Map<String,Object> queryAll(TbTeacherQueryCriteria criteria, Pageable pageable){
        Page<TbTeacher> page = tbTeacherRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbTeacherMapper::toDto));
    }

    @Override
    public List<TbTeacherDto> queryAll(TbTeacherQueryCriteria criteria){
        return tbTeacherMapper.toDto(tbTeacherRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TbTeacherDto findById(Integer teacherId) {
        TbTeacher tbTeacher = tbTeacherRepository.findById(teacherId).orElseGet(TbTeacher::new);
        ValidationUtil.isNull(tbTeacher.getTeacherId(),"TbTeacher","teacherId",teacherId);
        return tbTeacherMapper.toDto(tbTeacher);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbTeacherDto create(TbTeacher resources) {
        return tbTeacherMapper.toDto(tbTeacherRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbTeacher resources) {
        TbTeacher tbTeacher = tbTeacherRepository.findById(resources.getTeacherId()).orElseGet(TbTeacher::new);
        ValidationUtil.isNull( tbTeacher.getTeacherId(),"TbTeacher","id",resources.getTeacherId());
        tbTeacher.copy(resources);
        tbTeacherRepository.save(tbTeacher);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer teacherId : ids) {
            tbTeacherRepository.deleteById(teacherId);
        }
    }

    @Override
    public void download(List<TbTeacherDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TbTeacherDto tbTeacher : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("姓名", tbTeacher.getName());
            map.put("性别", tbTeacher.getSex());
            map.put("年龄", tbTeacher.getAge());
            map.put("学历", tbTeacher.getEducation());
            map.put("学历专业", tbTeacher.getEducationMajor());
            map.put("教授专业", tbTeacher.getTeachMajor());
            map.put("职称", tbTeacher.getTechnicalTitle());
            map.put("岗位", tbTeacher.getPostname());
            map.put("岗位类型", tbTeacher.getPositionNature());
            map.put("电话", tbTeacher.getTelNumber());
            map.put("QQ", tbTeacher.getQqNumber());
            map.put("微信", tbTeacher.getWxNumber());
            map.put("周工作日（起）", tbTeacher.getJobweekStart());
            map.put("周工作日（止）", tbTeacher.getJobweekEnd());
            map.put("入司时间", tbTeacher.getEntryTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}