package com.springboot.demo.service.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.ServiceException;
import com.springboot.demo.entity.base.BaseEntity;
import com.springboot.demo.mapper.base.BaseMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public class BaseService<T extends BaseEntity, M extends BaseMapper<T>> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected M baseMapper;

    public T selectById(Integer id) {
        try {
            return baseMapper.selectById(id);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "查询失败");
        }
    }

    public List<T> selectAll(String tableName) {
        try {
            return (List<T>) baseMapper.selectAll(tableName);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "查询失败");
        }
    }

    public List<T> selectBatchIds(Collection<Integer> ids) {
        try {
            if (CollectionUtils.isEmpty(ids))
                return Lists.newArrayList();
            return baseMapper.selectBatchIds(ids);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "查询失败");
        }
    }

    public int insert(T entity) {
        try {
            return baseMapper.insert(entity);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "添加失败");
        }
    }

    public int updateById(T entity) {
        try {
            return baseMapper.updateById(entity);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "更新数据失败");
        }
    }

    public int deleteById(Integer id) {
        try {
            return baseMapper.deleteById(id);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "删除失败");
        }
    }

    public int deleteBatchIds(Collection<Integer> ids) {
        try {
            return baseMapper.deleteBatchIds(ids);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "批量删除失败");
        }
    }

    public T selectByName(String name) {
        try {
            Wrapper<T> wrapper = new QueryWrapper<T>().eq("name", name);
            return baseMapper.selectOne(wrapper);
        } catch (ServiceException e) {
            throw new ServiceException(ApiBaseResponse.FAILURE_CODE, "批量删除失败");
        }
    }
}
