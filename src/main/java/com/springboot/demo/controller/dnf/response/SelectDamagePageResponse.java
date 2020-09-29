package com.springboot.demo.controller.dnf.response;

import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.entity.dnf.Damage;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
public class SelectDamagePageResponse {

    private Integer id;
    private String monster;
    private Integer duration; //时长，单位秒
    private String roleName;
    private Long damage;
    private Long createTime;
    private Long updateTime;

    public SelectDamagePageResponse accept(Damage damage, Map<Integer, String> roleMap) {
        BeanUtils.copyProperties(damage, this);
        this.roleName = roleMap.get(damage.getRoleId());
        return this;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Long getDamage() {
        return damage;
    }

    public void setDamage(Long damage) {
        this.damage = damage;
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
}
