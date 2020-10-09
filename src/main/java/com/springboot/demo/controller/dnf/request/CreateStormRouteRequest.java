package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.entity.dnf.StormRoute;

import java.util.Calendar;

/**
 * @author zwj * @since 1.0
 */
public class CreateStormRouteRequest {

    private Integer roleId;
    private String firstBoss;
    private String secondBoss;
    private Double minute;
    private Double second;
    private Double millisecond;

    public StormRoute adapt() {
        StormRoute stormRoute = new StormRoute();
        stormRoute.setRoleId(this.roleId);
        stormRoute.setFirstBoss(this.firstBoss);
        stormRoute.setSecondBoss(this.secondBoss);
        stormRoute.setPassTime(minute * 60 + second + millisecond / 100);
        stormRoute.setCreateTime(Calendar.getInstance().getTimeInMillis());
        stormRoute.setUpdateTime(Calendar.getInstance().getTimeInMillis());
        return stormRoute;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
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

    public Double getMinute() {
        return minute;
    }

    public void setMinute(Double minute) {
        this.minute = minute;
    }

    public Double getSecond() {
        return second;
    }

    public void setSecond(Double second) {
        this.second = second;
    }

    public Double getMillisecond() {
        return millisecond;
    }

    public void setMillisecond(Double millisecond) {
        this.millisecond = millisecond;
    }
}
