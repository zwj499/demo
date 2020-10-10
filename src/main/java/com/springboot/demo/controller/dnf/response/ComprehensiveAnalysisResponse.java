package com.springboot.demo.controller.dnf.response;

/**
 * @author zwj * @since 1.0
 */
public class ComprehensiveAnalysisResponse {

    private Integer roleId;
    private String roleName;
    private Double maxPassTime;
    private Double minPassTime;
    private Double avgPassTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Double getMaxPassTime() {
        return maxPassTime;
    }

    public void setMaxPassTime(Double maxPassTime) {
        this.maxPassTime = maxPassTime;
    }

    public Double getMinPassTime() {
        return minPassTime;
    }

    public void setMinPassTime(Double minPassTime) {
        this.minPassTime = minPassTime;
    }

    public Double getAvgPassTime() {
        return avgPassTime;
    }

    public void setAvgPassTime(Double avgPassTime) {
        this.avgPassTime = avgPassTime;
    }
}
