package com.springboot.demo.entity.sys;

import com.springboot.demo.common.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class SysUser extends BaseEntity {

    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
