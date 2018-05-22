package com.springmvc.entity.messages;

import com.springmvc.entity.enums.Errors;

public class ApiResponse<T> {

    private Boolean success = Boolean.TRUE;

    private Errors errors;

    private String errorCode;

    private String errorMsg;

    private T data;

    public static ApiResponse  invokeFaile(Errors errors){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.errors = errors;
        apiResponse.errorCode = errors.getErrorCode();
        apiResponse.errorMsg = errors.getErrorMsg();
        apiResponse.success = Boolean.FALSE;
        return apiResponse;
    }

    public static ApiResponse  invokeSuccess(Object data){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.success = Boolean.TRUE;
        apiResponse.data = data;
        return apiResponse;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Errors getErrors() {
        return errors;
    }

    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
