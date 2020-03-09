package com.springboot.demo.controller.sys.response;

import com.springboot.demo.common.base.enums.UserLevelEnum;
import com.springboot.demo.entity.sys.SysUser;
import org.springframework.beans.BeanUtils;

public class SelectSysUserPageResponse {

    private Integer id;
    private String name;
    private String password;
    private String level;
    private String phone;
    private String email;
    private Boolean active;

    public SelectSysUserPageResponse accept(SysUser sysUser) {
        BeanUtils.copyProperties(sysUser, this, "level");
        this.level = UserLevelEnum.fromCode(sysUser.getLevel()).getType();
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
