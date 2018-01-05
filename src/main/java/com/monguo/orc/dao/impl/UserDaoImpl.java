package com.monguo.orc.dao.impl;

import com.monguo.orc.dao.UserDao;
import com.monguo.orc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addUser(String name, String password) {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        mongoTemplate.insert(user);
    }

    @Override
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public void updateUser(User user) {
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(user.getId())),Update.update("name",user.getName()),User.class);
    }

    @Override
    public void deleteUser(String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)),User.class);
    }
}
