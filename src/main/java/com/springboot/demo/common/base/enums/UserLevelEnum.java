package com.springboot.demo.common.base.enums;


import java.util.Arrays;

public enum UserLevelEnum {
    SYS_ADMIN(0, "超管"),
    ADMIN(1, "管理员"),
    USER(2, "用户")
    ;


    private Integer code;
    private String type;

    UserLevelEnum(Integer code, String type) {
        this.code = code;
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static UserLevelEnum fromCode(Integer code) {
        return code == null ? null : Arrays.stream(UserLevelEnum.values())
                .filter(x -> x.getCode().equals(code)).findFirst().orElse(null);
    }
}
