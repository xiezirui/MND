package com.mnd.dao;

import com.mnd.pojo.Share;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShareMapper {
    //设置分享码
    int setSharePwd(@Param("uid") String uid, @Param("address") String address, @Param("password") String password, @Param("name") String nam, @Param("shareAddress") String shareAddress);

    //取消分享
    int deleteFile(String address);

    //获得分享信息(分享码)
    List<Share> getFileInfo(String address);

    //获得分享信息(文件地址)
    Share getShare(@Param("address") String address, @Param("password") String password);


}
