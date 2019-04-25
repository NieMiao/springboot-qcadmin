package qcadmin.auth.model;

import lombok.Data;
import qcadmin.auth.enums.AuthEnums;
import qcadmin.auth.exception.AuthException;

/**
 * @program: qcadmin_server
 * @description: 异常返回消息
 * @author: NieMiao
 * @create: 2019-04-25 15:54
 **/
@Data
public class ExceptionVO {

    private int code;
    private String message;

    public ExceptionVO(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public ExceptionVO(AuthException authException){
        this.code = authException.getCode();
        this.message = authException.getMessage();
    }
}
