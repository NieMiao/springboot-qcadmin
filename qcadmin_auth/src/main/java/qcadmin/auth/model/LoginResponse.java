package qcadmin.auth.model;

import lombok.Data;

/**
 * @program: qcadmin_server
 * @description: 登录返回参数
 * @author: NieMiao
 * @create: 2019-04-08 17:39
 **/
@Data
public class LoginResponse {
    private String username;
    private String token;
}
