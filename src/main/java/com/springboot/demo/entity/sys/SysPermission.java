package com.springboot.demo.entity.sys;

import com.springboot.demo.common.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class SysPermission extends BaseEntity {

    private String name;
    private String permission;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
