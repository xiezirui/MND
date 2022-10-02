package com.mnd.controller;

import com.mnd.pojo.User;
import com.mnd.service.UserService;
import com.mnd.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FileController fileController;

    @RequestMapping("/login")
    public String login(String email, String password, HttpServletRequest req){

        User user = userService.getUser(email, password);

        String result = null;

        if (user != null){
            result = "redirect:/selectFiles";

            req.getSession().setAttribute(Constants.USER_SESSION,user);
        }

        return result;
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest req){
        req.getSession().removeAttribute(Constants.USER_SESSION);

        return "redirect:/login.jsp";
    }

    @RequestMapping("/toHome")
    public String toHomePage(){
        return "redirect:/selectFiles";
    }

    @RequestMapping("/toUp")
    public String toUploadFile(){
        return "uploadFile";
    }

    @RequestMapping("/toShare")
    public String toShareFile(){
        return "redirect:/selectShare ";
    }
}
