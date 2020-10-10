package com.springboot.demo.service.dnf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.controller.dnf.request.SelectRolePageRequest;
import com.springboot.demo.controller.dnf.response.SelectRolePageResponse;
import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.entity.dnf.Role;
import com.springboot.demo.entity.sys.SysUser;
import com.springboot.demo.mapper.dnf.RoleMapper;
import com.springboot.demo.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService extends BaseService<Role, RoleMapper> {

    @Autowired
    private AccountService accountService;

    public IPage<SelectRolePageResponse> selectPage(SelectRolePageRequest request) {
        IPage<Role> page = new Page<>(request.getPageNo(), request.getPageSize());

        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(request.getSearchText())) {
            queryWrapper.like("name", request.getSearchText());
        }

        String orderBy = StringUtils.isBlank(request.getOrderBy()) ? "id" : camelToUnderline(request.getOrderBy());
        Boolean asc = request.getAsc() == null ? true : request.getAsc();

        queryWrapper.orderBy(true, asc, orderBy);

        IPage<Role> rolePage = baseMapper.selectPage(page, queryWrapper);

        Set<Integer> accountIdSet = rolePage.getRecords().stream().map(Role::getAccountId).collect(Collectors.toSet());

        List<Account> accounts = accountService.selectBatchIds(accountIdSet);
        Map<Integer, String> accountMap = accounts.stream().collect(Collectors.toMap(Account::getId, Account::getAccount));

        List<SelectRolePageResponse> roleResponse = rolePage.getRecords().stream().map(role -> new SelectRolePageResponse().accept(role, accountMap)).collect(Collectors.toList());

        IPage<SelectRolePageResponse> result = new Page<>();
        BeanUtils.copyProperties(rolePage, result, "records");
        result.setRecords(roleResponse);

        return result;
    }

    public List<Role> getRoles(SysUser currentUser) {
        List<Account> accounts = accountService.getByCurrentUser(currentUser.getId());
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        List<Integer> accountIds = accounts.stream().map(Account::getId).collect(Collectors.toList());
        queryWrapper.in("account_id", accountIds);
        return baseMapper.selectList(queryWrapper);
    }
}
