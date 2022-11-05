package com.mnd.dao;

import com.mnd.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

public interface UserMapper {
    //添加用户
    int addUser(@Param("id") String id, @Param("username") String username, @Param("password") String password, @Param("email") String email);

    //获得用户信息
    User getUser(@Param("email") String email, @Param("password") String password);

    //获得用户总数
    int getTotalUserNumber();

    //密码修改
    int pwdModify(@Param("password") String password, @Param("id") String id);

    //获得是否该邮箱已经注册过账户
    User getSignInUserByEmail(@Param("email") String email);
}
