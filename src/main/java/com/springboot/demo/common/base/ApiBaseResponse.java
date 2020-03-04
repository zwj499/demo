package com.springboot.demo.common.base;

/**
 * @author zwj * @since 1.0
 */
public class ApiBaseResponse<T> {

    public static final Integer SUCCESS_CODE = 1;
    public static final Integer FAILURE_CODE = 0;

    public static final String SUCCESS_MESSAGE = "请求成功";
    public static final String FAILURE_MESSAGE = "请求失败";

    private Integer code;
    private String message;
    private T data;

    public ApiBaseResponse() {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
    }

    public ApiBaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiBaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiBaseResponse(T data) {
        this(SUCCESS_CODE, SUCCESS_MESSAGE);
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
