package com.springboot.demo.controller.gdp.request;

/**
 * @author zwj * @since 1.0
 */
public class ProvinceYearGdpRequest {

    private String provinces;
    private String years;
    private Integer orderBy;
    private Boolean asc;

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getAsc() {
        return asc;
    }

    public void setAsc(Boolean asc) {
        this.asc = asc;
    }
}
