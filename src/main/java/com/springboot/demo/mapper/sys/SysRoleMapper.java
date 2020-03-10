package com.springboot.demo.mapper.sys;

import com.springboot.demo.mapper.base.BaseMapper;
import com.springboot.demo.entity.sys.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRole> selectByUserId(@Param("userId") Integer userId);

}
