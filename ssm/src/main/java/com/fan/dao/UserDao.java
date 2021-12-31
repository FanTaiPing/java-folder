package com.fan.dao;

import com.fan.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author y
 */
public interface UserDao {
    /**
     *
     * @param username
     * @param password
     * @return
     */
    User login(@Param("username")String username,@Param("password") String password);
}
