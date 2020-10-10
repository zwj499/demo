package com.springboot.demo.controller.dnf.enums;

/**
 * @author zwj * @since 1.0
 */
public enum  StormRouteAnalysisEnum {
    ANALYSIS_BY_MAP("analysis-by-map", "按地图分析"),
    ANALYSIS_BY_ROLE("analysis-by-role","按角色分析"),
    COMPREHENSIVE_ANALYSIS("comprehensive-analysis", "综合分析"),
    ;

    private String code;
    private String type;

    StormRouteAnalysisEnum(String code, String type) {
        this.code = code;
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
