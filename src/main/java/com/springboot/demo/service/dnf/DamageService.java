package com.springboot.demo.service.dnf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.common.base.ServiceException;
import com.springboot.demo.controller.dnf.request.CreateDamageRequest;
import com.springboot.demo.controller.dnf.request.SelectDamagePageRequest;
import com.springboot.demo.controller.dnf.response.SelectDamagePageResponse;
import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.entity.dnf.Damage;
import com.springboot.demo.entity.dnf.Role;
import com.springboot.demo.mapper.dnf.DamageMapper;
import com.springboot.demo.service.base.BaseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DamageService extends BaseService<Damage, DamageMapper> {

    @Autowired
    private RoleService roleService;

    public void saveOrUpdate(CreateDamageRequest request) {
        if (StringUtils.isEmpty(request.getMonster())
                || request.getDuration() == null
                || request.getRoleId() == null
                || request.getDamage() == null) {
            throw new ServiceException("参数异常");
        }

        QueryWrapper<Damage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("monster", request.getMonster())
                .eq("duration", request.getDuration())
                .eq("role_id", request.getRoleId());
        Damage damage = baseMapper.selectOne(queryWrapper);

        if (damage == null)
            baseMapper.insert(request.adapt());
        else if (damage.getDamage() < request.getDamage()) {
            damage.setUpdateTime(Calendar.getInstance().getTimeInMillis());
            damage.setDamage(request.getDamage());
            baseMapper.updateById(damage);
        }
    }

    public IPage<SelectDamagePageResponse> selectPage(SelectDamagePageRequest request) {
        IPage<Damage> page = new Page<>(request.getPageNo(), request.getPageSize());

        QueryWrapper<Damage> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(request.getMonster())) {
            queryWrapper.eq("monster", request.getMonster());
        }
        if (StringUtils.isNotBlank(request.getDuration())) {
            queryWrapper.eq("duration", request.getDuration());
        }

        String orderBy = StringUtils.isBlank(request.getOrderBy()) ? "id" :  camelToUnderline(request.getOrderBy());
        Boolean asc = request.getAsc() == null ? true : request.getAsc();

        queryWrapper.orderBy(true, asc, orderBy);

        IPage<Damage> damagePage = baseMapper.selectPage(page, queryWrapper);

        Set<Integer> roleIds = damagePage.getRecords().stream().map(Damage::getRoleId).collect(Collectors.toSet());

        List<Role> roles = roleService.selectBatchIds(roleIds);
        Map<Integer, String> roleMap = roles.stream().collect(Collectors.toMap(Role::getId, Role::getName));

        List<SelectDamagePageResponse> damageResponses = damagePage.getRecords().stream().map(damage -> new SelectDamagePageResponse().accept(damage, roleMap)).collect(Collectors.toList());

        IPage<SelectDamagePageResponse> result = new Page<>();
        BeanUtils.copyProperties(damagePage, result, "records");
        result.setRecords(damageResponses);

        return result;
    }
}
