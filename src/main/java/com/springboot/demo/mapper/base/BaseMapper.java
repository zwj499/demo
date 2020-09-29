package com.springboot.demo.mapper.base;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public interface BaseMapper<T> extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {

    @SelectProvider(type = SQLTemplate.class, method = "selectAll")
    List<T> selectAll(@Param("tableName") String tableName);

//    @InsertProvider(type = SQLTemplate.class, method = "insertAll")
//    Integer insertAll(@Param("list") List<T> list);

}
