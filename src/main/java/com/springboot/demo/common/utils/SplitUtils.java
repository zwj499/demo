package com.springboot.demo.common.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Set;

/**
 * @author zwj * @since 1.0
 */
public class SplitUtils {

    public static Set<Integer> stringToIntegerSet(String str, String separator) {
        return Sets.newHashSet(stringToIntegerList(str, separator));
    }

    public static Set<String> stringToSet(String str, String separator) {
        return Sets.newHashSet(stringToList(str, separator));
    }

    public static List<Integer> stringToIntegerList(String str, String separator) {
        List<Integer> result = Lists.newArrayList();
        if (StringUtils.isBlank(str))
            return result;
        for (String s : str.split(separator)) {
            if (StringUtils.isBlank(s))
                continue;
            result.add(Integer.parseInt(s));
        }
        return result;
    }


    public static List<String> stringToList(String str, String separator) {
        List<String> result = Lists.newArrayList();
        if (StringUtils.isBlank(str))
            return result;
        for (String s : str.split(separator)) {
            if (StringUtils.isBlank(s))
                continue;
            result.add(s);
        }
        return result;
    }

}
