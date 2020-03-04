package com.springboot.demo.entity;

import com.springboot.demo.common.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class Role extends BaseEntity {

    private String name;
    private String career;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
