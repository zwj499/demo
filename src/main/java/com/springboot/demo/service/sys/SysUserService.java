package com.springboot.demo.service.sys;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.service.base.BaseService;
import com.springboot.demo.controller.sys.request.SelectSysUserPageRequest;
import com.springboot.demo.controller.sys.response.SelectSysUserPageResponse;
import com.springboot.demo.entity.sys.SysUser;
import com.springboot.demo.mapper.sys.SysUserMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zwj * @since 1.0
 */
@Service
public class SysUserService extends BaseService<SysUser, SysUserMapper> {

    public IPage<SelectSysUserPageResponse> selectPage(SelectSysUserPageRequest request) {
        IPage<SysUser> page = new Page<>(request.getPageNo(), request.getPageSize());

        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(request.getName())) {
            queryWrapper.like("name", request.getName());
        }

        String orderBy = StringUtils.isBlank(request.getOrderBy()) ? "id" : camelToUnderline(request.getOrderBy());
        Boolean asc = request.getAsc() == null ? true : request.getAsc();

        queryWrapper.orderBy(true, asc, orderBy);

        IPage<SysUser> sysUserPage = baseMapper.selectPage(page, queryWrapper);

        List<SelectSysUserPageResponse> sysUserResponse = sysUserPage.getRecords().stream().map(s -> new SelectSysUserPageResponse().accept(s)).collect(Collectors.toList());

        IPage<SelectSysUserPageResponse> result = new Page<>();
        BeanUtils.copyProperties(sysUserPage, result, "records");
        result.setRecords(sysUserResponse);

        return result;
    }

}
