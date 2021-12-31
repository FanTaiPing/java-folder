package com.fan.dao;

import com.fan.entity.Student;

/**
 * @author y
 */
public interface StudentMapper {
    /**
     *
     * @param id
     * @return
     */
    Student getStudentById(int id);
}
