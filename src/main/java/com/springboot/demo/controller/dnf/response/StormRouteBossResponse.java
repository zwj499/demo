package com.springboot.demo.controller.dnf.response;

/**
 * @author zwj * @since 1.0
 */
public class StormRouteBossResponse {

    private String firstBoss;
    private String secondBoss;
    private String stormRouteName;

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

    public String getStormRouteName() {
        return stormRouteName;
    }

    public void setStormRouteName(String stormRouteName) {
        this.stormRouteName = stormRouteName;
    }
}
