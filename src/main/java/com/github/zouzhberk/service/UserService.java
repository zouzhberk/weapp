package com.github.zouzhberk.service;

import com.github.zouzhberk.orm.dao.UserDAO;
import com.github.zouzhberk.orm.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by berk (zouzhberk@163.com)) on 3/31/16.
 */
@Service
public class UserService
{

    @Autowired
    UserDAO userDAO;


    public UserEntity createUser(String username, String email)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(email);
        userEntity.setName(username);
        return userDAO.create(userEntity);
    }

    public void updateUser(String username, String email)
    {
        userDAO.findByName(username).map(userEntity -> {
            userEntity.setEmail(email);
            userEntity.setName(username);
            return userDAO.update(userEntity);
        }).orElse(null);
    }

    public List<UserEntity> listAll()
    {
        return userDAO.streamAllCustomers().collect(Collectors.toList());
    }

    public List<UserEntity> listAllUsersByEmail(String email)
    {
        return userDAO.findAllByEmail(email).collect(Collectors.toList());
    }
}
