package com.springboot.demo.controller.dnf.response;

/**
 * @author zwj * @since 1.0
 */
public class ComprehensiveAnalysisResponse {

    private Integer roleId;
    private String roleName;
    private Double maxPassTime;
    private String maxPassTimeString;
    private Double minPassTime;
    private String minPassTimeString;
    private Double avgPassTime;
    private String avgPassTimeString;
    private Integer passDungeonsNumber;


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

    public String getMaxPassTimeString() {
        return maxPassTimeString;
    }

    public void setMaxPassTimeString(String maxPassTimeString) {
        this.maxPassTimeString = maxPassTimeString;
    }

    public Double getMinPassTime() {
        return minPassTime;
    }

    public void setMinPassTime(Double minPassTime) {
        this.minPassTime = minPassTime;
    }

    public String getMinPassTimeString() {
        return minPassTimeString;
    }

    public void setMinPassTimeString(String minPassTimeString) {
        this.minPassTimeString = minPassTimeString;
    }

    public Double getAvgPassTime() {
        return avgPassTime;
    }

    public void setAvgPassTime(Double avgPassTime) {
        this.avgPassTime = avgPassTime;
    }

    public String getAvgPassTimeString() {
        return avgPassTimeString;
    }

    public void setAvgPassTimeString(String avgPassTimeString) {
        this.avgPassTimeString = avgPassTimeString;
    }

    public Integer getPassDungeonsNumber() {
        return passDungeonsNumber;
    }

    public void setPassDungeonsNumber(Integer passDungeonsNumber) {
        this.passDungeonsNumber = passDungeonsNumber;
    }
}
