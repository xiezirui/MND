package com.mnd.service;

import com.mnd.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserService {
    int addUser(String username, String password, String email);

    User getUser(String email, String password);

    int getTotalUserNumber();

    int pwdModify(String password, String id);

    User getSignInUserByEmail(String email);
}
