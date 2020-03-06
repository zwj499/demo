package com.springboot.demo.common.base;

/**
 * @author zwj * @since 1.0
 */
public class BaseController {

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

}
