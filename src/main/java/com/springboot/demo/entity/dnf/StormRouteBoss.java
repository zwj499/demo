package com.springboot.demo.entity.dnf;

import com.springboot.demo.entity.base.BaseEntity;

public class StormRouteBoss extends BaseEntity {

    private String firstBoss;
    private String secondBoss;

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
