package com.springboot.demo.service.dnf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.controller.dnf.request.SelectAccountPageRequest;
import com.springboot.demo.controller.dnf.response.SelectAccountPageResponse;
import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.mapper.dnf.AccountMapper;
import com.springboot.demo.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService extends BaseService<Account, AccountMapper> {

    public IPage<SelectAccountPageResponse> selectPage(SelectAccountPageRequest request) {
        IPage<Account> page = new Page<>(request.getPageNo(), request.getPageSize());

        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(request.getSearchText())) {
            queryWrapper.like("account", request.getSearchText());
        }

        String orderBy = StringUtils.isBlank(request.getOrderBy()) ? "id" : camelToUnderline(request.getOrderBy());
        Boolean asc = request.getAsc() == null ? true : request.getAsc();

        queryWrapper.orderBy(true, asc, orderBy);

        IPage<Account> accountPage = baseMapper.selectPage(page, queryWrapper);

        List<SelectAccountPageResponse> accountResponse = accountPage.getRecords().stream().map(account -> new SelectAccountPageResponse().accept(account)).collect(Collectors.toList());

        IPage<SelectAccountPageResponse> result = new Page<>();
        BeanUtils.copyProperties(accountPage, result, "records");
        result.setRecords(accountResponse);

        return result;
    }

    /**
     * 获取当前用户下的所有账号
     *
     * @param userId
     * @return
     */
    public List<Account> getByCurrentUser(Integer userId) {
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sys_user_id", userId);
        return baseMapper.selectList(queryWrapper);
    }

}
