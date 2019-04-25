package qcadmin.auth.exception;

import qcadmin.auth.enums.AuthEnums;

/**
 * @program: qcadmin_server
 * @description: 认证中心异常管理
 * @author: NieMiao
 * @create: 2019-04-11 14:55
 **/
public class AuthException extends RuntimeException {

    private Integer code;


    public AuthException (String message,Integer code){
        super(message);
        this.code = code;
    }

    public AuthException (AuthEnums authEnums){
        super(authEnums.getMessage());
        this.code = authEnums.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
