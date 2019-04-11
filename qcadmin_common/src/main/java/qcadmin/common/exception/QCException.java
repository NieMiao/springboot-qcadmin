package qcadmin.common.exception;

import lombok.Data;

/**
 * @program: springboot-qcadmin
 * @description: 通用异常处理类
 * @author: NieMiao
 * @create: 2019-03-21 09:54
 **/
@Data
public class QCException extends RuntimeException{

    private Integer code;


    public QCException (String message,Integer code){
        super(message);
        this.code = code;
    }
}
