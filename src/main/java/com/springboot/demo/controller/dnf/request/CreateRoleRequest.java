package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.entity.dnf.Role;

import java.util.Calendar;

/**
 * @author zwj * @since 1.0
 */
public class CreateRoleRequest {

    private Integer accountId;
    private String name;
    private Integer level;
    private String career;

    public Role buildRole() {
        Role role = new Role();
        role.setAccountId(this.accountId);
        role.setName(this.name);
        role.setLevel(this.level);
        role.setCareer(this.career);
        role.setCreateTime(Calendar.getInstance().getTimeInMillis());
        role.setUpdateTime(Calendar.getInstance().getTimeInMillis());
        return role;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
