package com.springboot.demo.common.base;

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
        try{
            return baseMapper.selectById(id);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "查询失败");
        }
    }

    public List<T> selectBatchIds(Collection<Integer> ids) {
        try{
            return baseMapper.selectBatchIds(ids);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "查询失败");
        }
    }

    public int insert(T entity) {
        try{
            return baseMapper.insert(entity);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "添加失败");
        }
    }

    public int updateById(T entity) {
        try{
            return baseMapper.updateById(entity);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "更新数据失败");
        }
    }

    public int deleteById(Integer id) {
        try{
            return baseMapper.deleteById(id);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "删除失败");
        }
    }

    public int deleteBatchIds(Collection<Integer> ids) {
        try{
            return baseMapper.deleteBatchIds(ids);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "批量删除失败");
        }
    }

    public List<T> selectAll(String tableName) {
        try{
            return (List<T>) baseMapper.selectAll(tableName);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(1, "批量删除失败");
        }
    }
}
