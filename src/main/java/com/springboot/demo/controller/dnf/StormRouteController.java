package com.springboot.demo.controller.dnf;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.ServiceException;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.controller.dnf.enums.StormRouteBossEnum;
import com.springboot.demo.controller.dnf.request.ComprehensiveAnalysisRequest;
import com.springboot.demo.controller.dnf.request.CreateStormRouteRequest;
import com.springboot.demo.controller.dnf.request.SelectStormRoutePageRequest;
import com.springboot.demo.entity.dnf.StormRoute;
import com.springboot.demo.mapper.dnf.StormRouteMapper;
import com.springboot.demo.service.dnf.StormRouteService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/dnf/stormRoute")
public class StormRouteController extends AbstractController<StormRoute, StormRouteMapper, StormRouteService> {

    @PostMapping("/selectPage")
    public ApiBaseResponse selectPage(@RequestBody SelectStormRoutePageRequest request) {
        try {
            return setResponseSuccess(service.selectPage(request));
        } catch (ServiceException e) {
            logger.error(e.getErrorMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @PostMapping("/comprehensiveAnalysis")
    public ApiBaseResponse comprehensiveAnalysis(@RequestBody ComprehensiveAnalysisRequest request) {
        try {
            return setResponseSuccess(service.comprehensiveAnalysis(request));
        } catch (ServiceException e) {
            logger.error(e.getErrorMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @PostMapping
    public ApiBaseResponse insert(@RequestBody CreateStormRouteRequest request) {
        try {
            service.saveOrUpdate(request);
            return setResponseSuccess();
        } catch (ServiceException e) {
            logger.error(e.getErrorMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @GetMapping("/firstBoss")
    public ApiBaseResponse firstBoss() {
        try {
            List<String> firstBossList = Arrays.stream(StormRouteBossEnum.values()).filter(s -> s.getType() == 1).map(s -> s.getName()).collect(Collectors.toList());
            return setResponseSuccess(firstBossList);
        } catch (ServiceException e) {
            logger.error(e.getErrorMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @GetMapping("/secondBoss")
    public ApiBaseResponse secondBoss(@RequestParam String firstBoss) {
        try {
            if (StringUtils.isBlank(firstBoss)) {
                return setResponseFailure("请先选择第一个Boss");
            }
            List<String> secondBossList = Arrays.stream(StormRouteBossEnum.values()).filter(s -> !StringUtils.equals(s.getName(), firstBoss)).map(s -> s.getName()).collect(Collectors.toList());
            return setResponseSuccess(secondBossList);
        } catch (ServiceException e) {
            logger.error(e.getErrorMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @GetMapping("/stormRouteTypes")
    public ApiBaseResponse stormRouteTypes() {
        try {
            return setResponseSuccess(StormRouteBossEnum.stormRouteBossResponseList);
        } catch (ServiceException e) {
            logger.error(e.getErrorMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

}
