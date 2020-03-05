//package com.springboot.demo.common.shiro;
//
//import com.springboot.demo.service.sys.SysUserService;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author zwj * @since 1.0
// */
//public class CustomRealm extends AuthorizingRealm {
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
//        //获取用户
////         principalCollection.getPrimaryPrincipal();
////        //获取权限列表
////        ArrayList<PageData> roles = (ArrayList<PageData>) user.get("roles");
////        //添加角色和权限
////        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
////        roles.forEach(item -> simpleAuthorizationInfo.addRole(item.getString("roleName")));
////        return simpleAuthorizationInfo;
//        return null;
//
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
//        String username = usernamePasswordToken.getUsername();
//
////        sysUserService.
//
//
//        return null;
//    }
//}
