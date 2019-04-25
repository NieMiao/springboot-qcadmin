package qcadmin.auth.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import qcadmin.auth.exception.AuthException;
import qcadmin.auth.model.ExceptionVO;
import qcadmin.common.VO.ResultVO;
import qcadmin.common.utils.ResultUtils;

/**
 * @program: qcadmin_server
 * @description: 通用异常捕获
 * @author: NieMiao
 * @create: 2019-04-25 15:25
 **/
@ControllerAdvice
public class ExceptionCatch {

    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public ExceptionVO handlerException(AuthException exception){
        return  new ExceptionVO(exception);
    }
}
