package com.springboot.demo.controller.base;

import com.springboot.demo.common.base.ApiBaseResponse;
import com.springboot.demo.common.base.ServiceException;
import com.springboot.demo.common.constant.RedisConstant;
import com.springboot.demo.entity.base.BaseEntity;
import com.springboot.demo.entity.sys.SysUser;
import com.springboot.demo.mapper.base.BaseMapper;
import com.springboot.demo.service.base.BaseService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.security.auth.Subject;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public class AbstractController<T extends BaseEntity, M extends BaseMapper<T>, S extends BaseService<T, M>> extends BaseController {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected S service;

    protected ApiBaseResponse<T> selectById(Integer id) {
        try {
            T result = service.selectById(id);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected ApiBaseResponse<List<T>> selectBatchIds(List<Integer> ids) {
        try {
            List<T> result = service.selectBatchIds(ids);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected ApiBaseResponse<List<T>> selectAll() {
        try {
            ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
            String className = type.getActualTypeArguments()[0].getTypeName();
            Class<T> tClass = (Class<T>) Class.forName(className);
            List<T> result = service.selectAll(tClass.getSimpleName());
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure();
        }
    }

    protected ApiBaseResponse<Integer> insert(T entity) {
        try {
            int result = service.insert(entity);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected ApiBaseResponse<T> updateById(T entity) {
        try {
            int result = service.updateById(entity);
            if (result != 1) {
                throw new ServiceException(-1, String.format("更新系统用户数据失败, id: {}", entity.getId()));
            }
            return setResponseSuccess(selectById(entity.getId()));
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected ApiBaseResponse<Integer> deleteById(Integer id) {
        try {
            int result = service.deleteById(id);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected ApiBaseResponse<Integer> deleteBatchIds(List<Integer> ids) {
        try {
            int result = service.deleteBatchIds(ids);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected ApiBaseResponse<T> selectByName(String name) {
        try {
            T result = service.selectByName(name);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
        }
    }

    protected SysUser currentUser() {
        Session session = SecurityUtils.getSubject().getSession();
        return (SysUser) session.getAttribute(RedisConstant.CURRENT_USER);
    }
}
