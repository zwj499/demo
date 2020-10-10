package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.common.base.request.CommonPageRequest;

/**
 * @author zwj * @since 1.0
 */
public class SelectStormRoutePageRequest extends CommonPageRequest {

    private String analysisType;
    private Integer roleId;
    private String firstBoss;
    private String secondBoss;

    public String getAnalysisType() {
        return analysisType;
    }

    public void setAnalysisType(String analysisType) {
        this.analysisType = analysisType;
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
}
