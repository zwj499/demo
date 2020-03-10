package com.springboot.demo.entity;

import com.springboot.demo.entity.base.BaseEntity;

public class DungeonsRecord extends BaseEntity {

    private Integer roleId;
    private Integer dungeonsId;
    private Integer throughTime;
    private Integer createTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getDungeonsId() {
        return dungeonsId;
    }

    public void setDungeonsId(Integer dungeonsId) {
        this.dungeonsId = dungeonsId;
    }

    public Integer getThroughTime() {
        return throughTime;
    }

    public void setThroughTime(Integer throughTime) {
        this.throughTime = throughTime;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}
