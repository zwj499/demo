package com.springboot.demo.entity.mongo;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zwj * @since 1.0
 */
public class ProvinceYearGdp {

    private String province;
    private Integer year;
    private Double value;
    private String unit = "亿";

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        ProvinceYearGdp pyg = (ProvinceYearGdp) obj;
        return StringUtils.equals(this.province, pyg.getProvince())
                && this.year.equals(pyg.getYear());
    }
}
