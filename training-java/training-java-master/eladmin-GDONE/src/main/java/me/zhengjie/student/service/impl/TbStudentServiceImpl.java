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
package me.zhengjie.student.service.impl;

import me.zhengjie.student.domain.TbStudent;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.utils.FileUtil;
import lombok.RequiredArgsConstructor;
import me.zhengjie.student.repository.TbStudentRepository;
import me.zhengjie.student.service.TbStudentService;
import me.zhengjie.student.service.dto.TbStudentDto;
import me.zhengjie.student.service.dto.TbStudentQueryCriteria;
import me.zhengjie.student.service.mapstruct.TbStudentMapper;
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
public class TbStudentServiceImpl implements TbStudentService {

    private final TbStudentRepository tbStudentRepository;
    private final TbStudentMapper tbStudentMapper;

    @Override
    public Map<String,Object> queryAll(TbStudentQueryCriteria criteria, Pageable pageable){
        Page<TbStudent> page = tbStudentRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(tbStudentMapper::toDto));
    }

    @Override
    public List<TbStudentDto> queryAll(TbStudentQueryCriteria criteria){
        return tbStudentMapper.toDto(tbStudentRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Transactional
    public TbStudentDto findById(Integer stId) {
        TbStudent tbStudent = tbStudentRepository.findById(stId).orElseGet(TbStudent::new);
        ValidationUtil.isNull(tbStudent.getStId(),"TbStudent","stId",stId);
        return tbStudentMapper.toDto(tbStudent);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbStudentDto create(TbStudent resources) {
        return tbStudentMapper.toDto(tbStudentRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(TbStudent resources) {
        TbStudent tbStudent = tbStudentRepository.findById(resources.getStId()).orElseGet(TbStudent::new);
        ValidationUtil.isNull( tbStudent.getStId(),"TbStudent","id",resources.getStId());
        tbStudent.copy(resources);
        tbStudentRepository.save(tbStudent);
    }

    @Override
    public void deleteAll(Integer[] ids) {
        for (Integer stId : ids) {
            tbStudentRepository.deleteById(stId);
        }
    }

    @Override
    public void download(List<TbStudentDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (TbStudentDto tbStudent : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("班级id", tbStudent.getClassId());
            map.put("姓名", tbStudent.getName());
            map.put("入学时间", tbStudent.getLeanTime());
            map.put("性别", tbStudent.getSex());
            map.put("生日", tbStudent.getBirthday());
            map.put("籍贯", tbStudent.getNativePlace());
            map.put("学历", tbStudent.getEducation());
            map.put("毕业院校", tbStudent.getGraduationSchool());
            map.put("专业", tbStudent.getMajor());
            map.put("身份证号码", tbStudent.getIdcode());
            map.put("手机号码", tbStudent.getTelNumber());
            map.put("QQ", tbStudent.getQqNumber());
            map.put("微信", tbStudent.getWxNumber());
            map.put("家庭住址", tbStudent.getJtAddress());
            map.put("现居住地址", tbStudent.getNowAddress());
            map.put("自我介绍", tbStudent.getSelfContext());
            map.put("学生照片id", tbStudent.getPhotoId());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}