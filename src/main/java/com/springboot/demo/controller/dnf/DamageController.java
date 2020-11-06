package com.springboot.demo.controller.dnf;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.controller.dnf.enums.MonsterEnum;
import com.springboot.demo.controller.dnf.request.CreateDamageRequest;
import com.springboot.demo.controller.dnf.request.SelectDamagePageRequest;
import com.springboot.demo.entity.dnf.Damage;
import com.springboot.demo.mapper.dnf.DamageMapper;
import com.springboot.demo.service.dnf.DamageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/dnf/damage")
public class DamageController extends AbstractController<Damage, DamageMapper, DamageService> {

//    @GetMapping("/list")
//    public ApiBaseResponse selectAll() {
//        return super.selectAll();
//    }

    @PostMapping("/selectPage")
    public ApiBaseResponse selectPage(@RequestBody SelectDamagePageRequest request) {
        try {
            return setResponseSuccess(service.selectPage(request));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @PostMapping
    public ApiBaseResponse insert(@RequestBody CreateDamageRequest request) {
        try {
            service.saveOrUpdate(request);
            return setResponseSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @GetMapping("/monsters")
    public ApiBaseResponse monsters() {
        try {
            List<String> monsters = Arrays.stream(MonsterEnum.values()).map(m -> m.getMonster()).collect(Collectors.toList());
            return setResponseSuccess(monsters);
        } catch (Exception e) {
            return setResponseFailure();
        }
    }

    @GetMapping("/durations")
    public ApiBaseResponse durations(@RequestParam String monster) {
        try {
            if (StringUtils.isBlank(monster)) {
                return setResponseFailure();
            }
            return setResponseSuccess(MonsterEnum.fromMonster(monster).getDurationList());
        } catch (Exception e) {
            return setResponseFailure();
        }
    }

    @GetMapping("/list")
    public ApiBaseResponse listDamage() {
        try {
            return setResponseSuccess(service.listDamageResponse());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

}
