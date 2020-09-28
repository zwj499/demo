package com.springboot.demo.controller.sys;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.constant.RedisConstant;
import com.springboot.demo.controller.base.BaseController;
import com.springboot.demo.controller.sys.request.LoginRequest;
import com.springboot.demo.entity.sys.SysUser;
import com.springboot.demo.service.sys.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/login")
    public ApiBaseResponse login(@RequestBody LoginRequest request) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
            subject.login(token);

            SysUser sysUser = sysUserService.selectByName(request.getUsername());
            subject.getSession().setAttribute(RedisConstant.CURRENT_USER, sysUser);

            return setResponseSuccess("登录成功");
        } catch (Exception e) {
            return setResponseFailure("登录失败");
        }
    }

    @PostMapping("/logout")
    public ApiBaseResponse logout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
            return setResponseSuccess("登出成功");
        } catch (Exception e) {
            return setResponseFailure("登出失败");
        }
    }

    @GetMapping("/unLogin")
    public String error() {
        return "无权限";
    }


}
