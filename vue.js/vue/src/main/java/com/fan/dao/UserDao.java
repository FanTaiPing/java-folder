package com.fan.dao;

import com.fan.entity.Users;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有用户信息
     * @return
     */
    List<Users> findAll();

    /**
     * 添加用户
     * @param user
     * @return
     */
   int insertUser(Users user);

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
   Users getUserById(int id);

    /**
     * 修改用户信息
     * @param user
     */
   void updateUser(Users user);

    /**
     * 根据id删除用户信息
     * @param id
     */
   void delUser(int id);

    /**
     * 根据用户名或电话号码进行模糊查询
     * @param username
     * @param telephone
     */
   List<Users> findLikeUsernameOrTelephone(@Param("username")String username,@Param("telephone")String telephone);
}
