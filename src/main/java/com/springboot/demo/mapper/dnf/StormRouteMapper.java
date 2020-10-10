package com.springboot.demo.mapper.dnf;

import com.springboot.demo.controller.dnf.request.ComprehensiveAnalysisRequest;
import com.springboot.demo.controller.dnf.response.ComprehensiveAnalysisResponse;
import com.springboot.demo.entity.dnf.StormRoute;
import com.springboot.demo.mapper.base.BaseMapper;

import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public interface StormRouteMapper extends BaseMapper<StormRoute> {

    List<ComprehensiveAnalysisResponse> comprehensiveAnalysis(ComprehensiveAnalysisRequest request);

}
