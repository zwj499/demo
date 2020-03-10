package com.springboot.demo.controller.gdp;

import com.alibaba.excel.EasyExcel;
import com.mongodb.MongoException;
import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.BaseController;
import com.springboot.demo.service.gdp.listener.ProvinceYearGdpListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/gdp/provinceYear")
public class ProvinceYearGdpController extends BaseController {

    @Autowired
    private MongoTemplate mongoTemplate;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/importExcel")
    public ApiBaseResponse importExcel(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), new ProvinceYearGdpListener(mongoTemplate)).sheet().doRead();
            return setResponseSuccess();
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure("读取文件失败");
        } catch (MongoException e) {
            return setResponseFailure(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

}
