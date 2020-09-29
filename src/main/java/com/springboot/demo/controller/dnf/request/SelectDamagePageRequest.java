package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.common.base.request.CommonPageRequest;

/**
 * @author zwj * @since 1.0
 */
public class SelectDamagePageRequest extends CommonPageRequest {

    private String monster;
    private String duration;

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
