/**
* @author xiezirui
* @date 2022/4/10 9:01
*/

package com.mnd.service;

import com.mnd.dao.FileMapper;
import com.mnd.pojo.File;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FileServiceImpl implements FileService{

    @Autowired
    private FileMapper fileMapper;

    @Override
    public int fileUpload(String id, String fileName, String fileAddress, String fileSize, String fileFormat) {
        return fileMapper.fileUpload(id,fileName,fileAddress,fileSize,fileFormat);
    }

    @Override
    public List<File> getFileByUserIdandName(String id,String name) {
        return fileMapper.getFileByUserIdandName(id,name);
    }

    @Override
    public int deleteFile(String address) {
        return fileMapper.deleteFile(address);
    }

    @Override
    public List<File> getShareFile(String id) {
        return fileMapper.getShareFile(id);
    }

    @Override
    public int updataFileState(String address, String state) {
       return fileMapper.updataFileState(address,state);
    }

    @Override
    public int getTotalUploadFileNumber() {
        return fileMapper.getTotalUploadFileNumber();
    }

}
