package com.springboot.demo.entity;

import com.springboot.demo.entity.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class Province extends BaseEntity {

    private String name;
    private String wm;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWm() {
        return wm;
    }

    public void setWm(String wm) {
        this.wm = wm;
    }
}
