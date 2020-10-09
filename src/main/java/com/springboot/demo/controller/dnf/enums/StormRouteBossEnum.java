package com.springboot.demo.controller.dnf.enums;

import com.springboot.demo.controller.dnf.response.StormRouteBossResponse;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum StormRouteBossEnum {

    /*
        盗墓者骨狱息
        虫王戮蛊
        贝里斯克
        巨型黑章鱼
        全金属机甲
        巨灵布鲁
        虚空之弗曼
        锤王波罗丁
        巨龙石像
        牛头械王
        黑鳞莫贝尼
        机械吉赛尔

        变身魔人普利昂
     */

    GRAVE_ROBBERS_GUYUXI("盗墓者骨狱息", 1),
    INSECT_KING_LUGU("虫王戮蛊", 1),
    BELISK("贝里斯克", 1),
    GIANT_BLACK_OCTOPUS("巨型黑章鱼", 1),
    ALL_METAL_MECHA("全金属机甲", 1),
    MONSTER_SPIRIT_BRU("巨灵布鲁", 1),
    FURMAN_OF_VOID("虚空之弗曼", 1),
    HAMMER_KING_BOLODIN("锤王波罗丁", 1),
    GIANT_DRAGON_STATUE("巨龙石像", 1),
    BULL_MECHANICAL_KING("牛头械王", 1),
    BLACK_SCALE_MOBINI("黑鳞莫贝尼", 1),
    MECHANICAL_GISELLE("机械吉赛尔", 1),


    SHAPESHIFTING_DEMON_POLYON("变身魔人普利昂", 0),
    ;


    private String name;
    private Integer type; // 0: 只能为第二boss， 1：可以为第一boss和第二boss

    private static List<String> firstBosses;
    private static List<String> secondBosses;
    public static List<StormRouteBossResponse> stormRouteBossResponseList;

    static {
        firstBosses = Arrays.stream(StormRouteBossEnum.values()).filter(s -> s.type == 1).map(s -> s.name).collect(Collectors.toList());
        secondBosses = Arrays.stream(StormRouteBossEnum.values()).map(s -> s.name).collect(Collectors.toList());
        stormRouteBossResponseList = Lists.newArrayList();
        for (String firstBoss : firstBosses) {
            for (String secondBoss : secondBosses) {
                if (!StringUtils.equals(firstBoss, secondBoss)) {
                    StormRouteBossResponse stormRouteBossResponse = new StormRouteBossResponse();
                    stormRouteBossResponse.setFirstBoss(firstBoss);
                    stormRouteBossResponse.setSecondBoss(secondBoss);
                    stormRouteBossResponse.setStormRouteName(firstBoss + "/" + secondBoss);
                    stormRouteBossResponseList.add(stormRouteBossResponse);
                }
            }
        }
    }

    StormRouteBossEnum(String name, Integer type) {
        this.name = name;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
