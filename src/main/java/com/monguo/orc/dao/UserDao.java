package com.monguo.orc.dao;

import com.monguo.orc.pojo.User;

import java.util.List;

public interface UserDao {
    void addUser(String name, String password);

    List<User> listUser();

    void updateUser(User user);

    void deleteUser(String id);
}
