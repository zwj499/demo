package com.springboot.demo.service.dnf;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.demo.common.base.ServiceException;
import com.springboot.demo.common.utils.PageUtils;
import com.springboot.demo.controller.dnf.request.ComprehensiveAnalysisRequest;
import com.springboot.demo.controller.dnf.request.CreateStormRouteRequest;
import com.springboot.demo.controller.dnf.request.SelectStormRoutePageRequest;
import com.springboot.demo.controller.dnf.response.ComprehensiveAnalysisResponse;
import com.springboot.demo.controller.dnf.response.SelectStormRoutePageResponse;
import com.springboot.demo.entity.dnf.Role;
import com.springboot.demo.entity.dnf.StormRoute;
import com.springboot.demo.mapper.dnf.StormRouteMapper;
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

/**
 * @author zwj * @since 1.0
 */
@Service
public class StormRouteService extends BaseService<StormRoute, StormRouteMapper> {

    @Autowired
    private RoleService roleService;

    public void saveOrUpdate(CreateStormRouteRequest request) {
        if (request.getRoleId() == null
                || StringUtils.isBlank(request.getFirstBoss())
                || StringUtils.isBlank(request.getSecondBoss())
                || request.getSecond() == null) {
            throw new ServiceException("参数异常");
        }

        QueryWrapper<StormRoute> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id", request.getRoleId())
                .eq("first_boss", request.getFirstBoss())
                .eq("second_boss", request.getSecondBoss());
        StormRoute stormRoute = baseMapper.selectOne(wrapper);

        Double passTime = request.getMinute() * 60 + request.getSecond() + request.getMillisecond() / 100;
        if (stormRoute == null)
            baseMapper.insert(request.adapt());
        else if (stormRoute.getPassTime() > passTime) {
            stormRoute.setUpdateTime(Calendar.getInstance().getTimeInMillis());
            stormRoute.setPassTime(passTime);
            baseMapper.updateById(stormRoute);
        }
    }

    public IPage<SelectStormRoutePageResponse> selectPage(SelectStormRoutePageRequest request) {
        IPage<StormRoute> page = new Page<>(request.getPageNo(), request.getPageSize());

        QueryWrapper<StormRoute> queryWrapper = new QueryWrapper<>();

        if (StringUtils.equals("map", request.getAnalysisType())) {
            if (StringUtils.isNotBlank(request.getFirstBoss())) {
                queryWrapper.eq("first_boss", request.getFirstBoss());
            }
            if (StringUtils.isNotBlank(request.getSecondBoss())) {
                queryWrapper.eq("second_boss", request.getSecondBoss());
            }
        } else if (StringUtils.equals("role", request.getAnalysisType())) {
            if (request.getRoleId() != null) {
                queryWrapper.eq("role_id", request.getRoleId());
            }
        }

        String orderBy = StringUtils.isBlank(request.getOrderBy()) ? "id" : camelToUnderline(request.getOrderBy());
        Boolean asc = request.getAsc() == null ? true : request.getAsc();

        queryWrapper.orderBy(true, asc, orderBy);

        IPage<StormRoute> stormRoutePage = baseMapper.selectPage(page, queryWrapper);

        Set<Integer> roleIds = stormRoutePage.getRecords().stream().map(StormRoute::getRoleId).collect(Collectors.toSet());

        List<Role> roles = roleService.selectBatchIds(roleIds);
        Map<Integer, String> roleMap = roles.stream().collect(Collectors.toMap(Role::getId, Role::getName));

        List<SelectStormRoutePageResponse> stormRouteResponses = stormRoutePage.getRecords().stream().map(stormRoute -> new SelectStormRoutePageResponse().accept(stormRoute, roleMap)).collect(Collectors.toList());

        IPage<SelectStormRoutePageResponse> result = new Page<>();
        BeanUtils.copyProperties(stormRoutePage, result, "records");
        result.setRecords(stormRouteResponses);

        return result;
    }

    public Page<ComprehensiveAnalysisResponse> comprehensiveAnalysis(ComprehensiveAnalysisRequest request) {
        String orderBy = StringUtils.isBlank(request.getOrderBy()) ? "id" : camelToUnderline(request.getOrderBy());
        Boolean asc = request.getAsc() == null ? true : request.getAsc();
        request.setOrderBy(orderBy);
        request.setAsc(asc);

        List<ComprehensiveAnalysisResponse> comprehensiveAnalysisResponses = baseMapper.comprehensiveAnalysis(request);
        Page<ComprehensiveAnalysisResponse> page = new Page<>(request.getPageNo(), request.getPageSize(), comprehensiveAnalysisResponses.size());

        PageUtils.doPage(page, comprehensiveAnalysisResponses);

        return page;
    }
}
