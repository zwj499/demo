package com.springboot.demo.entity.dnf;

import com.springboot.demo.entity.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class StormRoute extends BaseEntity {

    private Integer roleId;
    private String firstBoss;
    private String secondBoss;
    private Double passTime;
    private Long createTime;
    private Long updateTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getFirstBoss() {
        return firstBoss;
    }

    public void setFirstBoss(String firstBoss) {
        this.firstBoss = firstBoss;
    }

    public String getSecondBoss() {
        return secondBoss;
    }

    public void setSecondBoss(String secondBoss) {
        this.secondBoss = secondBoss;
    }

    public Double getPassTime() {
        return passTime;
    }

    public void setPassTime(Double passTime) {
        this.passTime = passTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
