package com.qcadmin.common.enums;

/**
 * @program: springboot-com.qcadmin
 * @description: 返回状态枚举
 * @author: NieMiao
 * @create: 2019-03-21 09:58
 **/
public enum  ResultEnums {

    ;

    private String code;

    private String message;

    ResultEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
