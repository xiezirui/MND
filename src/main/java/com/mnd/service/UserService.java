package com.mnd.service;

import com.mnd.pojo.User;


public interface UserService {
    int addUser(String username, String password, String email);

    User getUser(String email, String password);

    int getTotalUserNumber();

    int pwdModify(String password, String id);
}
