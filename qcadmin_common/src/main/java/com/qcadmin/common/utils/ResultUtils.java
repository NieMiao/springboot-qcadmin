package com.qcadmin.common.utils;

import com.qcadmin.common.VO.ResultVO;
import com.qcadmin.common.enums.StateCode;

/**
 * @program: springboot-com.qcadmin
 * @description: http请求对象封装对象
 * @author: NieMiao
 * @create: 2018-10-08 15:52
 **/
public class ResultUtils {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setState(true);
        resultVO.setCode(StateCode.SUCCESS);
        return resultVO;
    }
    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setState(true);
        resultVO.setCode(StateCode.SUCCESS);
        return resultVO;
    }
    public static ResultVO error(int code) {
        ResultVO resultVO = new ResultVO();
        resultVO.setState(false);
        resultVO.setCode(code);
        return resultVO;
    }

}
