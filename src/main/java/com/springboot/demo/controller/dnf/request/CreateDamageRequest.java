package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.entity.dnf.Account;
import com.springboot.demo.entity.dnf.Damage;
import com.springboot.demo.entity.sys.SysUser;

import java.util.Calendar;

/**
 * @author zwj * @since 1.0
 */
public class CreateDamageRequest {
    private String monster;
    private String duration; //时长，单位秒
    private Integer roleId;
    private Long damage;

    public Damage adapt() {
        Damage damage = new Damage();
        damage.setMonster(this.monster);
        damage.setDuration(this.duration);
        damage.setRoleId(this.roleId);
        damage.setDamage(this.damage);
        damage.setCreateTime(Calendar.getInstance().getTimeInMillis());
        damage.setUpdateTime(Calendar.getInstance().getTimeInMillis());
        return damage;
    }

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

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Long getDamage() {
        return damage;
    }

    public void setDamage(Long damage) {
        this.damage = damage;
    }
}
