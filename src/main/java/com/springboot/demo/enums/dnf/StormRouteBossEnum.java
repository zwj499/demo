package com.springboot.demo.enums.dnf;

public enum  StormRouteBossEnum {

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

    GRAVE_ROBBERS_GUYUXI(1, "盗墓者骨狱息"),
    INSECT_KING_LUGU(2, "虫王戮蛊"),
    BELISK(3, "贝里斯克"),
//    INSECT_KING_LUGU(4, "巨型黑章鱼"),

    ;

    private Integer code;
    private String name;

    StormRouteBossEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
