package com.monguo.orc.Service.impl;

import com.monguo.orc.Service.UserService;
import com.monguo.orc.dao.UserDao;
import com.monguo.orc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(String name, String password) {
        userDao.addUser(name,password);
    }

    @Override
    public List<User> listUser() {

        return  userDao.listUser();
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }
}
