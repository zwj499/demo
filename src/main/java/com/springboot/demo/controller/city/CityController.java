package com.springboot.demo.controller.city;

import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.entity.City;
import com.springboot.demo.mapper.CityMapper;
import com.springboot.demo.service.city.CityService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
public class CityController extends AbstractController<City, CityMapper, CityService> {



}
