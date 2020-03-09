package com.springboot.demo.controller.sys;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.AbstractController;
import com.springboot.demo.common.base.BaseController;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zwj * @since 1.0
 */
@RestController
public class LoginController extends BaseController {

    @PostMapping("/login")
    public ApiBaseResponse login(String username, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
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
