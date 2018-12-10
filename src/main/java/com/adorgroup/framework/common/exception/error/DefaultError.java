package com.adorgroup.framework.common.exception.error;

/**
 * @author benju.xie
 * @version 0.0.1
 * @datetime 2017/5/10 17:58
 */
public enum DefaultError implements IError {
    SYSTEM_INTERNAL_ERROR("0000", "System Internal Error"),

    TOKEN_NOT_FOUND("0001", "Token Not Found"),
    INVALID_TOKEN("0002", "Invalid Token"),
    SIGN_NOT_FOUND("0003", "Sign Not Found"),
    INVALID_SIGN("0004", "Invalid Sign");


    String errorCode;
    String errorMessage;
    private static final String ns = "SYS";

    private DefaultError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private DefaultError(String errorCode, String errorMessage, String zh_errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getNamespace() {
        return "SYS";
    }

    public String getErrorCode() {
        return "SYS." + this.errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

}