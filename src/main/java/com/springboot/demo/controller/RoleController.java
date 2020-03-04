package com.springboot.demo.controller;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.BaseController;
import com.springboot.demo.entity.Role;
import com.springboot.demo.mapper.RoleMapper;
import com.springboot.demo.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController extends BaseController<Role, RoleMapper, RoleService> {

    @GetMapping("/{id}")
    public ApiBaseResponse<Role> selectById(@PathVariable ("id") Integer id) {
        return super.selectById(id);
    }

    @GetMapping("/list")
    public ApiBaseResponse<List<Role>> selectAll() {
        return super.selectAll("role");
    }
}
