/**
* @author xiezirui
* @date 2022/4/13 20:57
*/

package com.mnd.util;

import org.springframework.stereotype.Component;

import java.text.DecimalFormat;

@Component
public class ByteConversion {

    public String byteToOthers(long size){
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (size == 0) {
            return wrongSize;
        }
        if (size < 1024) {
            fileSizeString = df.format((double) size) + "B";
        } else if (size < 1048576) {
            fileSizeString = df.format((double) size / 1024) + "KB";
        } else if (size < 1073741824) {
            fileSizeString = df.format((double) size / 1048576) + "MB";
        } else if (size < 1099511627776L) {
            fileSizeString = df.format((double) size / 1073741824) + "GB";
        }

        return fileSizeString;
    }
}
