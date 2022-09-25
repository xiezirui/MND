package com.mnd.until;

import java.util.UUID;

public class GetUserId {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
