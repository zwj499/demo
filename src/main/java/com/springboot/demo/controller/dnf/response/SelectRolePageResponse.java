package com.springboot.demo.controller.dnf.response;

import com.springboot.demo.entity.dnf.Role;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
public class SelectRolePageResponse {

    private Integer id;
    private String account;
    private String name;
    private Integer level;
    private String career;
    private Long createTime;
    private Long updateTime;

    public SelectRolePageResponse accept(Role role, Map<Integer, String> accountMap) {
        BeanUtils.copyProperties(role, this);
        this.account = accountMap.getOrDefault(role.getAccountId(), "");
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
