package com.mnd.controller;

import com.mnd.pojo.User;
import com.mnd.service.UserService;
import com.mnd.util.Constants;
import com.mnd.util.Log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("toSignin")
    public String toSignIn(){
        return "signin";
    }

    @RequestMapping("/toHome")
    public String toHomePage(){
        return "redirect:/selectFiles";
    }

    @RequestMapping("/toUp")
    public String toUploadFile(){
        return "uploadFile";
    }

    @RequestMapping("toDown")
    public String toDownloadFile(){
        return "downloadFile";
    }

    @RequestMapping("/toShare")
    public String toShareFile(){
        return "redirect:/selectShare ";
    }

    @RequestMapping("/signin")
    public String SignIn(String username, String email, String password, HttpServletRequest req, Model model){

        String result = null;

        if (userService.getSignInUserByEmail(email) == null){
            userService.addUser(username,password,email);

            req.getSession().setAttribute(Constants.USER_SESSION,userService.getUser(email, password));

            result = "redirect:/selectFiles";
        }else {

            model.addAttribute(Constants.MESSAGE,"对不起，此账户已注册，请重试或登录已有账户");

            result  ="signin";
        }

        model.addAttribute(Constants.MESSAGE,"对不起，你必须填写信息");
        result  ="signin";


        return result;
    }
}
