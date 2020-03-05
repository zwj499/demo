package com.springboot.demo.common.utils;

import org.springframework.util.DigestUtils;

/**
 * @author zwj * @since 1.0
 */
public class MD5Util {

    private static final String slat = "zwj@demo";

    public static String encryptMD5(String str) {
        String base = str + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }

}
