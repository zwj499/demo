package com.springboot.demo.controller.sys.request;

import com.springboot.demo.entity.sys.SysUser;
import org.apache.commons.lang3.StringUtils;

public class CreateSysUserRequest {

    private String name;
    private String password;
    private String phone;
    private String email;

    public SysUser buildSysUser() {
        SysUser sysUser = new SysUser();
        sysUser.setName(this.name);
        sysUser.setPassword(this.password);
        sysUser.setPhone(this.phone);
        if (StringUtils.isNotBlank(email)) {
            sysUser.setEmail(this.email);
        }
        sysUser.setLevel(2);
        sysUser.setActive(true);
        return sysUser;
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
}
