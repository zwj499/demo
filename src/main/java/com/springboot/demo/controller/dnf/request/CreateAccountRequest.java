package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.entity.sys.SysUser;

import java.util.Calendar;

/**
 * @author zwj * @since 1.0
 */
public class CreateAccountRequest {

    private String account;

    public Account adapt(SysUser sysUser) {
        Account account = new Account();
        account.setAccount(this.account);
        account.setCreateTime(Calendar.getInstance().getTimeInMillis());
        account.setSysUserId(sysUser.getId());
        return account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
