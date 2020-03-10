package com.springboot.demo.entity.sys;

import com.springboot.demo.entity.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class SysRolePermission extends BaseEntity {

    private Integer roleId;
    private Integer permissionId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
