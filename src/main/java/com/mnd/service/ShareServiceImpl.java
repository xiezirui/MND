package com.mnd.service;

import com.mnd.dao.ShareMapper;
import com.mnd.pojo.Share;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareMapper shareMapper;

    @Override
    public int setSharePwd(String uid, String address, String password, String name, String shareAddress) {
        return shareMapper.setSharePwd(uid,address,password,name,shareAddress);
    }

    @Override
    public int deleteFile(String address) {
        return shareMapper.deleteFile(address);
    }

    @Override
    public List<Share> getFileInfo(String address) {
        return shareMapper.getFileInfo(address);
    }

    @Override
    public Share getShare(String address, String password) {
        return shareMapper.getShare(address,password);
    }

}
