package com.springboot.demo.controller.role.request;


import com.springboot.demo.entity.Role;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;

/**
 * @author zwj * @since 1.0
 */
public class CreateRoleRequest {

    @NotNull(message = "用户名不能为空")
    @Length(min = 2, max = 16, message = "用户名长度在2到16位之间")
    private String name;
    @NotNull(message = "职业不能为空")
    private String career;

    public Role adapt() {
        Role role = new Role();
        BeanUtils.copyProperties(this, role);
        return role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }
}
