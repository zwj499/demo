package com.springboot.demo.entity.dnf;

import com.springboot.demo.entity.base.BaseEntity;

public class DnfRole extends BaseEntity {

    private String name;
    private Integer career;
    private Integer level;
    private String qq;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCareer() {
        return career;
    }

    public void setCareer(Integer career) {
        this.career = career;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}
