package com.springmvc.entity.messages;

import com.springmvc.entity.enums.Errors;

public class ApiResponse<T> {

    private Boolean success = Boolean.TRUE;

    private Errors errors;

    private String errorCode;

    private String errorMsg;

    private T data;

    public void invokeFaile(Errors errors){
        this.errors = errors;
        this.errorCode = errors.getErrorCode();
        this.errorMsg = errors.getErrorMsg();
        this.success = Boolean.FALSE;
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
