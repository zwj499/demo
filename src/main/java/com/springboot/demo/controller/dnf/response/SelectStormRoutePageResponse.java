package com.springboot.demo.controller.dnf.response;

import com.springboot.demo.common.base.ServiceException;
import com.springboot.demo.entity.dnf.StormRoute;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
public class SelectStormRoutePageResponse {

    private String firstBoss;
    private String secondBoss;
    private String roleName;
    private Double passTime;
    private String passTimeString;
    private Long createTime;
    private Long updateTime;

    public SelectStormRoutePageResponse accept(StormRoute stormRoute, Map<Integer, String> roleMap) {
        BeanUtils.copyProperties(stormRoute, this);
        this.roleName = roleMap.get(stormRoute.getRoleId());
        this.passTimeString = parsePassTime(stormRoute.getPassTime());
        return this;
    }

    public String getFirstBoss() {
        return firstBoss;
    }

    public void setFirstBoss(String firstBoss) {
        this.firstBoss = firstBoss;
    }

    public String getSecondBoss() {
        return secondBoss;
    }

    public void setSecondBoss(String secondBoss) {
        this.secondBoss = secondBoss;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Double getPassTime() {
        return passTime;
    }

    public void setPassTime(Double passTime) {
        this.passTime = passTime;
    }

    public String getPassTimeString() {
        return passTimeString;
    }

    public void setPassTimeString(String passTimeString) {
        this.passTimeString = passTimeString;
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

    private String parsePassTime(Double passTime) {
        StringBuilder sb = new StringBuilder();
        Integer seconds = passTime.intValue();
        if (seconds < 0) {
            throw new ServiceException("时间不能小于0");
        }
        if (seconds >= 60) {
            sb.append(seconds / 60).append("分")
                    .append(seconds % 60).append("秒");
        }
        sb.append(passTime.toString().split("\\.")[1]);
        return sb.toString();
    }
}
