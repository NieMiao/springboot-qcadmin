package qcadmin.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @program: qcadmin_server
 * @description: token实体类
 * @author: NieMiao
 * @create: 2019-04-11 15:32
 **/
@NoArgsConstructor
@Data
@ToString
public class AuthToken {
        String access_token;//访问token就是短令牌，用户身份令牌
        String refresh_token;//刷新token
        String jwt_token;//jwt令牌
}
