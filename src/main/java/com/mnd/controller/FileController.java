
package com.mnd.controller;

import com.mnd.pojo.File;
import com.mnd.pojo.User;
import com.mnd.service.FileService;
import com.mnd.util.ByteConversion;
import com.mnd.util.Constants;
import com.mnd.util.Log.Log;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @Autowired
    private ByteConversion byteConversion;

    @RequestMapping("/selectFiles")
    public String selectFiles(Model model, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        List<File> files = fileService.getFileByUserIdandName(user.getId(), null);

        model.addAttribute(Constants.FILES,files);

        return "homePage";
    }

    @RequestMapping("/selectShare")
    public String selectShare(Model model, HttpServletRequest req){
        User user = (User) req.getSession().getAttribute(Constants.USER_SESSION);

        List<File> files = fileService.getFileByUserIdandName(user.getId(), null);

        model.addAttribute(Constants.FILES,files);

        return "shareFile";
    }

    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        //存放地址
        String uuidPATH = UUID.randomUUID().toString();
        String timePATH = String.valueOf(System.currentTimeMillis());
        //文件真是存在的路径
        String filePath = uuidPATH + timePATH;

        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        //上传路径保存设置
        String path = request.getSession().getServletContext().getRealPath("WEB-INF/upload/" + filePath);
        java.io.File realPath = new java.io.File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }

        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）

        file.transferTo(new java.io.File(realPath +"/"+ file.getOriginalFilename()));
        //在数据库中添加文件数据
        fileService.fileUpload(user.getId(),file.getOriginalFilename(),filePath,byteConversion.byteToOthers(file.getSize()),file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")));

        return "redirect:/selectFiles";
    }

    @RequestMapping(value = "download")
    @ResponseBody
    public String fileDownload(String address, String fileName, HttpServletResponse resp , HttpServletRequest req) throws IOException {

        Log.log(address);
        Log.log(fileName);
        //要下载的图片地址
        String path = req.getSession().getServletContext().getRealPath("WEB-INF/upload/" + address);
        //1、设置response 响应头
        resp.reset(); //设置页面不缓存,清空buffer
        resp.setCharacterEncoding("UTF-8"); //字符编码
        resp.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        resp.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));
        java.io.File file = new java.io.File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = resp.getOutputStream();
        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return "OK";
    }

    @RequestMapping("delete")
    public String fileDelete(HttpServletRequest req,String address,String fileName){

        String fileUrl = req.getSession().getServletContext().getRealPath("") + "WEB-INF\\upload\\" + address + "\\" + fileName;
        String fileUrlpar = req.getSession().getServletContext().getRealPath("") + "WEB-INF\\upload\\" + address;

        new java.io.File(fileUrl).delete();
        new java.io.File(fileUrlpar).delete();


        int i = fileService.deleteFile(address);

        return "redirect:/selectFiles";

    }

}
