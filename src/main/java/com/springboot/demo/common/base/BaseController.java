package com.springboot.demo.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zwj * @since 1.0
 */
public class BaseController<T extends BaseEntity, M extends BaseMapper<T>, S extends BaseService<T, M>> {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private S service;

    protected ApiBaseResponse setResponseSuccess() {
        return new ApiBaseResponse();
    }

    protected ApiBaseResponse setResponseSuccess(Object data) {
        return new ApiBaseResponse(data);
    }

    protected ApiBaseResponse setResponseFailure(Integer code, String message) {
        return new ApiBaseResponse(code, message);
    }

    protected ApiBaseResponse setResponseFailure(String message) {
        return new ApiBaseResponse(ApiBaseResponse.FAILURE_CODE, message);
    }

    protected ApiBaseResponse setResponseFailure() {
        return new ApiBaseResponse(ApiBaseResponse.FAILURE_CODE, ApiBaseResponse.FAILURE_MESSAGE);
    }

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

    protected ApiBaseResponse<List<T>> selectAll(String tableName) {
        try {
            List<T> result = service.selectAll(tableName);
            return setResponseSuccess(result);
        } catch (ServiceException e) {
            logger.error(e.getMessage(), e);
            return setResponseFailure(e.getErrorCode(), e.getErrorMessage());
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

    protected ApiBaseResponse<Integer> updateById(T entity) {
        try {
            int result = service.updateById(entity);
            return setResponseSuccess(result);
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
}
