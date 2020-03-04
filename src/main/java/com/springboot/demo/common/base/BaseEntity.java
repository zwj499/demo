package com.springboot.demo.common.base;

import java.io.Serializable;

/**
 * @author zwj * @since 1.0
 */
public abstract class BaseEntity implements Serializable {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
