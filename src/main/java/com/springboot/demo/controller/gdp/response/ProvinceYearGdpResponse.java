package com.springboot.demo.controller.gdp.response;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
public class ProvinceYearGdpResponse {

    private String province;
    private Map<Integer, Double> yearGdpMap = Maps.newHashMap();

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Map<Integer, Double> getYearGdpMap() {
        return yearGdpMap;
    }

    public void setYearGdpMap(Map<Integer, Double> yearGdpMap) {
        this.yearGdpMap = yearGdpMap;
    }
}
