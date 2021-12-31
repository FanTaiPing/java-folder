package com.fan.dao;

import com.fan.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author y
 */
public interface UserDao {
    /**
     * 查询用户表里面的所有数据
     * @return
     */
    List<User> findAllUser();

    /**
     * 根据id查询单条用户数据
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 根据用户id和name查询用户数据
     * @param id
     * @param name
     * @return
     */
    User getUserByIdAndName(@Param("id")int id,@Param("name")String name);

    /**
     * 查询用户表里的所有数据条数
     * @return
     */
    int count();

    /**
     * 添加用户数据
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 删除用户数据
     * @param user
     * @return
     */
    int deleteUser(User user);

    /**
     * 修改员工数据
     * @param user
     * @return
     */
    int updateUser(User user);
}
