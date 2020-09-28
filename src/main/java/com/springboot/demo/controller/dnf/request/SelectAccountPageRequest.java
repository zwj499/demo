package com.springboot.demo.controller.dnf.request;

import com.springboot.demo.common.base.request.CommonPageRequest;

/**
 * @author zwj * @since 1.0
 */
public class SelectAccountPageRequest extends CommonPageRequest {

    private String searchText;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
}
