package com.fan.dao;

/**
 * @author y
 */
public interface UserDao {
    void save(String name);
    String findAll(String name) throws Exception;
}
