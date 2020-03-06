package com.springboot.demo.controller.sys;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.AbstractController;
import com.springboot.demo.entity.sys.SysUser;
import com.springboot.demo.mapper.sys.SysUserMapper;
import com.springboot.demo.service.sys.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/sys_user")
public class SysUserController extends AbstractController<SysUser, SysUserMapper, SysUserService> {

    @GetMapping("/selectByName")
    public ApiBaseResponse<SysUser> selectByName(@RequestParam("name") String name) {
        return super.selectByName(name);
    }

}
