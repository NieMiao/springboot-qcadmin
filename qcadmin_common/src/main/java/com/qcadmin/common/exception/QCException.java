package com.qcadmin.common.exception;

import lombok.Data;
import com.qcadmin.common.enums.ResultEnums;

/**
 * @program: springboot-com.qcadmin
 * @description: 通用异常处理类
 * @author: NieMiao
 * @create: 2019-03-21 09:54
 **/
@Data
public class QCException extends RuntimeException{

    private String code;

    public  QCException (ResultEnums resultEnums){
        super(resultEnums.getMessage());
        this.code = resultEnums.getCode();
    }

    public QCException (String message,String code){
        super(message);
        this.code = code;
    }
}
