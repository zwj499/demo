package com.springboot.demo.controller.dnf.enums;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public enum MonsterEnum {
    GREEN_SANDBAG("绿沙袋", Lists.newArrayList("10s", "15s", "20s"))
    ;

    private String monster;
    private List<String> durationList;

    public static MonsterEnum fromMonster(String monster) {
        return monster == null ? null : Arrays.stream(MonsterEnum.values()).filter(x ->
                StringUtils.equals(monster, x.getMonster())).findFirst().orElse(null);
    }

    MonsterEnum(String monster, List<String> durationList) {
        this.monster = monster;
        this.durationList = durationList;
    }

    public String getMonster() {
        return monster;
    }

    public void setMonster(String monster) {
        this.monster = monster;
    }

    public List<String> getDurationList() {
        return durationList;
    }

    public void setDurationList(List<String> durationList) {
        this.durationList = durationList;
    }
}
