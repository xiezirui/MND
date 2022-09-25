package com.mnd.controller;

import com.mnd.pojo.File;
import com.mnd.pojo.User;
import com.mnd.service.UserService;
import com.mnd.until.Constants;
import com.mnd.until.Log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.soap.SAAJMetaFactory;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private FileController fileController;

    @RequestMapping("/login")
    public String login(Model model, String email, String password, HttpServletRequest req){

        User user = userService.getUser(email, password);

        String result = null;

        //Log.log(user.toString());

        if (user != null){
            result = "redirect:/selectFiles";

            req.getSession().setAttribute(Constants.USER_SESSION,user);
        }

        return result;
    }

}
