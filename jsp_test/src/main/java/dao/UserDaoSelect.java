package dao;

import java.util.List;

import entity.User;

public interface UserDaoSelect {
List<User> findUserInfo(User user);
}
