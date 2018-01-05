package com.monguo.orc.controller;

import com.monguo.orc.Service.UserService;
import com.monguo.orc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class TestController {
@Autowired
    private UserService userService;
@RequestMapping("adduser/{name}/{password}")
    public void addUser(@PathVariable String name,@PathVariable String password){
            userService.addUser(name,password);
    }
    @RequestMapping("listUser")
    public List<User> listUser(){
       List<User> list= userService.listUser();
        return list;
    }
@RequestMapping("updateUser/{id}/{name}")
    public void updateUser(@PathVariable String id,@PathVariable String name){
        User user = new User();
        user.setId(id);
        user.setName(name);
        userService.updateUser(user);
}
@RequestMapping("deleteUser/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
}
}
