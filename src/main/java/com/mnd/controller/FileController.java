package com.mnd.controller;

import com.mnd.pojo.File;
import com.mnd.pojo.User;
import com.mnd.service.FileService;
import com.mnd.until.Constants;
import com.mnd.until.Log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/selectFiles")
    public String selectFiles(Model model, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        //Log.log(user.toString());

        List<File> files = fileService.getFileByUserIdandName(user.getId(), null);

        //Log.log(files.toString());

        model.addAttribute(Constants.FILES,files);

        return "homePage";
    }

}
