package com.tt.association.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * Created by by@Deng on 2017/7/11.
 */
public class UUIDUtils {

    private UUIDUtils(){}

    /**
     * 获取uuid
     * @return
     */
    public static String getUUID(){
        return StringUtils.replaceAll(UUID.randomUUID().toString(),"-","");
    }


}
