package com.springboot.demo.common.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public class PageUtils {

    public static <T> List<T> getSubList(List<T> data, int pageNo, int pageSize) {
        int start = getStart(data.size(), pageNo, pageSize);
        int end = getEnd(data.size(), start, pageNo, pageSize);
        return data.subList(start, end);
    }

    private static int getStart(int size, int pageNo, int pageSize) {
        int start = (pageNo - 1) * pageSize;
        if (start >= size)
            return 0;
        return start;
    }

    private static int getEnd(int size, int start, int pageNo, int pageSize) {
        int end = pageNo * pageSize;
        if (end > size) {
            end = size;
            if ((end - start) > pageSize) {
                end = pageSize;
            }
        }
        return end;
    }

    public static <X> void doPage(Page<X> page, List<X> resultList) {
        page.setTotal(resultList.size());
        List<X> resultToPage = Lists.newArrayList(getSubList(resultList, Long.valueOf(page.getCurrent()).intValue(), Long.valueOf(page.getSize()).intValue()));
        page.setRecords(resultToPage);
    }

    public static <X> Page<X> createEmptyPage(int pageNo, int pageSize) {
        Page<X> page = new Page<>(pageNo, pageSize);
        page.setTotal(0);
        page.setRecords(Lists.newArrayList());
        return page;
    }
}
