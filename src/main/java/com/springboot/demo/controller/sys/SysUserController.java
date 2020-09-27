package com.springboot.demo.controller.sys;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.controller.base.AbstractController;
import com.springboot.demo.controller.sys.request.CreateSysUserRequest;
import com.springboot.demo.controller.sys.request.SelectSysUserPageRequest;
import com.springboot.demo.controller.sys.request.UpdateSysUserRequest;
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

    @GetMapping("/{id}")
    public ApiBaseResponse<SysUser> selectById(@PathVariable Integer id) {
        return super.selectById(id);
    }

    @PostMapping
    public ApiBaseResponse insert(@RequestBody CreateSysUserRequest request) {
        SysUser sysUser = request.buildSysUser();
        super.insert(sysUser);
        return setResponseSuccess();
    }

    @PutMapping("/{id}")
    public ApiBaseResponse<SysUser> update(@PathVariable("id") Integer id, @RequestBody UpdateSysUserRequest request) {
        SysUser sysUser = service.selectById(id);
        sysUser.setPhone(request.getPhone());
        sysUser.setEmail(request.getEmail());
        return super.updateById(sysUser);
    }

    @PutMapping("/{id}/active")
    public ApiBaseResponse<SysUser> updateActive(@PathVariable("id") Integer id, @RequestParam("active") Boolean active) {
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

    @DeleteMapping("/{id}")
    public ApiBaseResponse delete(@PathVariable("id") Integer id) {
        return super.deleteById(id);
    }
}
