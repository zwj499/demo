package com.springboot.demo.entity.dnf;

import com.springboot.demo.entity.base.BaseEntity;

public class Career extends BaseEntity {

    private static final long serialVersionUID = 1756165181050409403L;
    private Integer baseCareer;
    private String career;

    public Integer getBaseCareer() {
        return baseCareer;
    }

    public void setBaseCareer(Integer baseCareer) {
        this.baseCareer = baseCareer;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
