package com.springboot.demo.entity.sys;

import com.springboot.demo.common.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class SysRole extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
