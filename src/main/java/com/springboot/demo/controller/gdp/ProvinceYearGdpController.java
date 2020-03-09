package com.springboot.demo.controller.gdp;

import com.alibaba.excel.EasyExcel;
import com.mongodb.MongoException;
import com.springboot.demo.common.base.AbstractController;
import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.BaseController;
import com.springboot.demo.service.gdp.listener.ProvinceYearGdpListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/gdp/prvinceYear")
public class ProvinceYearGdpController extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiBaseResponse importExcel(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), new ProvinceYearGdpListener()).sheet().doRead();
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
