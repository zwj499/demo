package com.springboot.demo.controller.sys.request;

import com.springboot.demo.common.base.request.CommonPageRequest;

public class SelectSysUserPageRequest extends CommonPageRequest {

    // 模糊搜索name
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
