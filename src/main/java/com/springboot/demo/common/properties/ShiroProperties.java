package com.springboot.demo.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author zwj * @since 1.0
 */
@Configuration
@ConfigurationProperties(prefix = ShiroProperties.SHIRO_PREFIX)
public class ShiroProperties {

    public final static String SHIRO_PREFIX = "spring.shiro";

    private Map<String,String> filterChainDefinitions;

    public Map<String, String> getFilterChainDefinitions() {
        return filterChainDefinitions;
    }

    public void setFilterChainDefinitions(Map<String, String> filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }
}
