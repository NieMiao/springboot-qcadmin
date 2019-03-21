package qcadmin.common.VO;

import lombok.Data;

/**
 * @program: qcadmin
 * @description: http请求返回最外层对象
 * @author: NieMiao
 * @create: 2018-10-08 14:34
 **/
@Data
public class ResultVO<T> {

    private boolean state;

    private int code;

    private T data;

    private int dateCount;

}
