package com.fan.service;

/**
 * @author y
 */
public interface UserService {
    void save(String name);
    void delete(String id);
    void update();
    String findAll(String name);
    String findOne(String id);
}
