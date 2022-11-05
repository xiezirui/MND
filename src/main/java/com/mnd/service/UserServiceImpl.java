package com.mnd.service;

import com.mnd.dao.UserMapper;
import com.mnd.pojo.User;
import com.mnd.util.GetUserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier(value = "userMapper")
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public int addUser(String username, String password, String email) {
        return userMapper.addUser(GetUserId.getUUID(),username,password,email);
    }

    @Override
    public User getUser(String email, String password) {
        return userMapper.getUser(email,password);
    }

    @Override
    public int getTotalUserNumber() {

        return userMapper.getTotalUserNumber();
    }

    @Override
    public int pwdModify(String password, String id) {
        return userMapper.pwdModify(password,id);
    }

    @Override
    public User getSignInUserByEmail(String email) {
        return userMapper.getSignInUserByEmail(email);
    }
}

