package com.mnd.dao;

import com.mnd.pojo.File;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface FileMapper {
    //添加文件
    int fileUpload(@Param("id") String id,@Param("fileName") String fileName, @Param("fileAddress") String fileAddress, @Param("fileSize") String fileSize, @Param("fileFormat") String fileFormat);

    //查询文件
    List<File> getFileByUserIdandName(@Param("id") String id, @Param("name") String name);

    //查询该用户已经分享的文件
    List<File> getShareFile(@Param("id") String id);

    //删除文件
    int deleteFile(String address);

    //更新文件分享状态
    int updataFileState(@Param("address") String address, @Param("state") String state);

    //获得已经上传文件总数
    int getTotalUploadFileNumber();
}
