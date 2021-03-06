package com.springboot.demo.controller.dnf;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.controller.dnf.request.CreateRoleRequest;
import com.springboot.demo.controller.dnf.request.SelectRolePageRequest;
import com.springboot.demo.entity.dnf.Role;
import com.springboot.demo.mapper.dnf.RoleMapper;
import com.springboot.demo.service.dnf.RoleService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/dnf/role")
public class RoleController extends AbstractController<Role, RoleMapper, RoleService> {

    @PostMapping("/selectPage")
    public ApiBaseResponse selectPage(@RequestBody SelectRolePageRequest request) {
        try {
            return setResponseSuccess(service.selectPage(request));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @PostMapping
    public ApiBaseResponse insert(@RequestBody CreateRoleRequest request) {
        try {
            super.insert(request.adapt());
            return setResponseSuccess();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    @GetMapping
    public ApiBaseResponse getRoles() {
        try {
            return setResponseSuccess(service.getRoles(currentUser()));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

}
