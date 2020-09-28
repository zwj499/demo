package com.springboot.demo.controller.dnf.response;

import com.springboot.demo.entity.dnf.Account;
import org.springframework.beans.BeanUtils;

/**
 * @author zwj * @since 1.0
 */
public class SelectAccountPageResponse {

    private Integer id;
    private String account;
    private Long createTime;
    private Integer roleCount = 0;

    public SelectAccountPageResponse accept(Account account) {
        BeanUtils.copyProperties(account, this);
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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getRoleCount() {
        return roleCount;
    }

    public void setRoleCount(Integer roleCount) {
        this.roleCount = roleCount;
    }
}
