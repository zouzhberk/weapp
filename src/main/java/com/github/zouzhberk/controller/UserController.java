package com.github.zouzhberk.controller;

import com.github.zouzhberk.orm.entity.UserEntity;
import com.github.zouzhberk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by berk (zouzhberk@163.com)) on 3/31/16.
 */
@RequestMapping("/user")
@RestController
public class UserController
{

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public UserEntity addUser(@RequestParam("name") String username,
                              @RequestParam("email") String email)
    {
        return userService.createUser(username, email);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserEntity> listAllUsers()
    {
        return userService.listAll();
    }
}
