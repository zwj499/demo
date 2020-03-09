package com.springboot.demo.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
public class Gov {



    public static void main(String[] args) {
        EasyExcel.read(new File(filePath), new GdpListener()).sheet().doRead();
        int w = 2;
    }




































    private static String filePath = "C:\\Users\\zhuangwj\\Downloads\\分省年度数据.xls";
}
