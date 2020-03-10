package com.springboot.demo.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.controller.sys.request.SelectSysUserPageRequest;
import com.springboot.demo.controller.sys.response.SelectSysUserPageResponse;
import com.springboot.demo.entity.sys.SysUser;
import com.springboot.demo.mapper.sys.SysUserMapper;
import com.springboot.demo.service.sys.SysUserService;
import org.springframework.web.bind.annotation.*;

/**
 * @author zwj * @since 1.0
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController extends AbstractController<SysUser, SysUserMapper, SysUserService> {

    @GetMapping("/selectByName")
    public ApiBaseResponse<SysUser> selectByName(@RequestParam("name") String name) {
        return super.selectByName(name);
    }

    @PostMapping
    public ApiBaseResponse insert(@RequestBody SysUser sysUser) {
        super.insert(sysUser);
        return setResponseSuccess();
    }

    @PutMapping("/{id}/active")
    public ApiBaseResponse<SysUser> update(@PathVariable("id") Integer id, @RequestParam("active") Boolean active) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        sysUser.setActive(active);
        return super.updateById(sysUser);
    }


    @PostMapping("/selectPage")
    public ApiBaseResponse<IPage<SelectSysUserPageResponse>> selectPage(@RequestBody SelectSysUserPageRequest request) {
        try {
            IPage<SelectSysUserPageResponse> sysUserPage = service.selectPage(request);
            return setResponseSuccess(sysUserPage);
        } catch (Exception e) {
            return setResponseFailure();
        }
    }

}
