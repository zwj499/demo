package com.springboot.demo.common.utils;

import com.springboot.demo.common.base.ServiceException;

/**
 * @author zwj * @since 1.0
 */
public class TimeParseUtil {

    public static String parsePassTime(Double passTime) {
        StringBuilder sb = new StringBuilder();
        Integer seconds = passTime.intValue();
        if (seconds < 0) {
            throw new ServiceException("时间不能小于0");
        }
        if (seconds >= 60) {
            sb.append(seconds / 60).append("分");
        }
        sb.append(seconds % 60).append("秒");
        sb.append(passTime.toString().split("\\.")[1]);
        return sb.toString();
    }

}
