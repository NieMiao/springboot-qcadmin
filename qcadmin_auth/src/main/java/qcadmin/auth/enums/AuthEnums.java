package qcadmin.auth.enums;

public enum AuthEnums {

    USERNAME_EMPTY_ERROR(10001,"用户名为空!"),
    PASSWORD_EMPTY_ERROR(10002,"密码为空!"),
    TOKEN_APPLY_FAIL(10003,"token申请失败!"),
    TOKEN_SAVE_FAIL(10004,"token存入redis失败"),
    ACCOUNT_NOT_EXISTS(10005,"验证失败，帐号不存在！"),
    AUTH_CREDENTIAL_ERROR(10006,"验证失败，凭证无效"),
    TOKEN_DEL_FAIL(10007,"token删除失败")
    ;

    private Integer code;
    private String message;

    AuthEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
