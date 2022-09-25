package com.mnd.service;

import com.mnd.pojo.Share;

import java.util.List;

public interface ShareService {
    int setSharePwd(String uid, String address, String password, String name, String shareAddress);

    int deleteFile(String address);

    List<Share> getFileInfo(String address);

    Share getShare(String address, String password);
}
