package com.springboot.demo.controller.dnf;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.entity.dnf.Career;
import com.springboot.demo.mapper.dnf.CareerMapper;
import com.springboot.demo.service.dnf.CareerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dnf/career")
public class CareerController extends AbstractController<Career, CareerMapper, CareerService> {

    @GetMapping("/list")
    public ApiBaseResponse selectAll() {
        return this.selectAll();
    }

    @GetMapping("/baseCareer")
    public ApiBaseResponse baseCareers() {
        try {
            return setResponseSuccess(service.queryBaseCareers());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @GetMapping("/career/{baseCareerId}")
    public ApiBaseResponse careers(@PathVariable Integer baseCareerId) {
        try {
            return setResponseSuccess(service.queryCareersByBaseCareerId(baseCareerId));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

}
