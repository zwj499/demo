package com.springboot.demo.entity.dnf;

import com.springboot.demo.entity.base.BaseEntity;

/**
 * @author zwj * @since 1.0
 */
public class Account extends BaseEntity {

    private static final long serialVersionUID = -8658433867850600711L;
    private String account;
    private Long createTime;
    private Integer sysUserId;

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

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }
}
