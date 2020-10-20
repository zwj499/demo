package com.springboot.demo.mapper.dnf;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.demo.controller.dnf.response.SelectAccountPageResponse;
import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.mapper.base.BaseMapper;

public interface AccountMapper extends BaseMapper<Account> {
    IPage<SelectAccountPageResponse> selectPage(IPage<Account> page);
}
