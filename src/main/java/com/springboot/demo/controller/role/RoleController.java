package com.springboot.demo.controller.role;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.AbstractController;
import com.springboot.demo.controller.role.request.CreateRoleRequest;
import com.springboot.demo.controller.role.request.UpdateRoleRequest;
import com.springboot.demo.entity.Role;
import com.springboot.demo.mapper.RoleMapper;
import com.springboot.demo.service.RoleService;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.Duration;
import java.util.List;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController extends AbstractController<Role, RoleMapper, RoleService> {

    @GetMapping("/{id}")
    public ApiBaseResponse<Role> selectById(@PathVariable ("id") Integer id) {
        return super.selectById(id);
    }

    @GetMapping("/list")
    public ApiBaseResponse<List<Role>> selectAll() {
        return super.selectAll("role");
    }

    @PostMapping
    public ApiBaseResponse<Integer> insert(@RequestBody @Valid CreateRoleRequest request) {
        return super.insert(request.adapt());
    }

    @PutMapping
    public ApiBaseResponse update(@RequestBody @Valid UpdateRoleRequest request, Errors errors) {
        ObjectError objectError = errors.getAllErrors().stream().findFirst().orElse(null);
        if (objectError != null) {
            return setResponseFailure(objectError.getDefaultMessage());
        }
        return super.updateById(request.adapt());
    }

    @DeleteMapping("/{id}")
    public ApiBaseResponse delete(@PathVariable("id") Integer id) {
        return super.deleteById(id);
    }

    @DeleteMapping("/batch")
    public ApiBaseResponse deleteBatchByIds(@RequestBody List<Integer> ids) {
        return super.deleteBatchIds(ids);
    }
}
