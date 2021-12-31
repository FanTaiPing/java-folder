package com.fan.dao;

import com.fan.entity.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author y
 */
public interface TeacherMapper {
    /**
     *
     * @param id
     * @return
     */
    Teacher getTeacherById(int id);
}
