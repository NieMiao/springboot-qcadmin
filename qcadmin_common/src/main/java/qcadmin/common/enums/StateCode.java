package qcadmin.common.enums;


/**
 * @program: springboot-qcadmin
 * @description: 状态码
 * @author: NieMiao
 * @create: 2019-03-21 10:35
 **/
public class  StateCode {

    public static final int SUCCESS = 20000;//成功
    public static final int ERROR = 20001;//失败
    public static final int LOGIN_ERROR =20002;//用户名或密码错误
    public static final int ACCESS_ERROR =20003;//权限不足
    public static final int REMOTE_ERROR =20004;//远程调用失败
    public static final int REP_ERROR =20005;//重复操作
}
