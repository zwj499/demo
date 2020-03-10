package com.springboot.demo.controller.province;

import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.entity.Province;
import com.springboot.demo.mapper.ProvinceMapper;
import com.springboot.demo.service.province.ProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/province")
public class ProvinceController extends AbstractController<Province, ProvinceMapper, ProvinceService> {

    @GetMapping("/list")
    public ApiBaseResponse selectAll() {
        return super.selectAll();
    }

}
