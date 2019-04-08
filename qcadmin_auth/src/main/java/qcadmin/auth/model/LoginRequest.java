package qcadmin.auth.model;

import lombok.Data;

/**
 * @program: qcadmin_server
 * @description: 登录请求参数
 * @author: NieMiao
 * @create: 2019-04-08 17:36
 **/
@Data
public class LoginRequest {

    private String username;
    private String password;

}
