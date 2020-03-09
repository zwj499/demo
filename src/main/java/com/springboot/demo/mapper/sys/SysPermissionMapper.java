package com.springboot.demo.mapper.sys;

import com.springboot.demo.common.base.BaseMapper;
import com.springboot.demo.entity.sys.SysPermission;
import org.apache.ibatis.annotations.Param;

import java.security.Permission;
import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {

    List<Permission> selectByRoleId(@Param("roleId") Integer roleId);

    List<String> selectByUserId(@Param("userId") Integer userId);

}
