package com.fan.controller;

import com.fan.entity.Users;
import com.fan.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
@CrossOrigin //跨域
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findAll")
    public List<Users> findAll() {
        return userService.findAll();
    }

    @GetMapping("getUserById")
    public Users getUserById(int id) {
        return userService.getUserById(id);
    }

    @PostMapping("updateOrInsertUser")
    public Map<String, Object> updateUser(@RequestBody Users user) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            if (user.getId() == 0) {
                userService.insertUser(user);
                map.put("success", true);
                map.put("message", "添加用户成功！");
            } else {
                userService.updateUser(user);
                map.put("success", true);
                map.put("message", "修改用户成功！");
            }


        } catch (Exception e) {
            map.put("success", false);
            map.put("message", "操作用户失败！");
        }
        return map;
    }

    @GetMapping("delUser")
    public Map<String, Object> delUser(int id) {
        Map<String, Object> map = new HashMap<>(16);
        try {
            userService.delUser(id);
            map.put("success", "true");
            map.put("message", "删除用户成功！");
        } catch (Exception e) {
            map.put("success", "true");
            map.put("message", "删除用户失败！请联系管理员！");
        }
        return map;
    }

    @PostMapping("findLike")
    public List<Users> findLikeUsernameOrTelephone(@RequestParam("username") String username, @RequestParam("telephone") String telephone) {
        return userService.findLikeUsernameOrTelephone(username, telephone);
    }
}
