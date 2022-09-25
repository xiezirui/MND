package com.mnd.service;

import com.mnd.pojo.File;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface FileService {
    int fileUpload(String id, String fileName, String fileAddress, String fileSize, String fileFormat);

    List<File> getFileByUserIdandName(String id, String name);

    List<File> getShareFile(String id);

    int deleteFile(String address);

    int updataFileState(String address, String state);

    int getTotalUploadFileNumber();
}
