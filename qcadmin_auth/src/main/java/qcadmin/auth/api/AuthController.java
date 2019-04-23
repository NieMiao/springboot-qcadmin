package qcadmin.auth.api;

import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import qcadmin.auth.enums.AuthEnums;
import qcadmin.auth.exception.AuthException;
import qcadmin.auth.model.AuthToken;
import qcadmin.auth.model.LoginRequest;
import qcadmin.auth.service.AuthService;
import qcadmin.common.VO.ResultVO;
import qcadmin.common.utils.ResultUtils;

/**
 * @program: springboot-com.qcadmin
 * @description: 认证服务接口
 * @author: NieMiao
 * @create: 2019-03-28 11:52
 **/
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    AuthService authService;

    @Value("${auth.clientId}")
    String clientId;
    @Value("${auth.clientSecret}")
    String clientSecret;

    @PostMapping("/userLogin")
    public ResultVO login(@RequestBody LoginRequest loginRequest){
        //对用户名和密码进行非空判断
        if(StringUtils.isEmpty(loginRequest.getUsername())){
            throw new AuthException(AuthEnums.USERNAME_EMPTY_ERROR);
        }
        if (StringUtils.isEmpty(loginRequest.getPassword())){
            throw new AuthException(AuthEnums.PASSWORD_EMPTY_ERROR);
        }

        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        //申请token
        AuthToken authToken = authService.login(clientId, clientSecret, username, password);
        //todo
        // 将令牌存入cookie，之后再做
        return ResultUtils.success(authToken);
    }

    @PostMapping("/userLogout")
    public ResultVO logout(){
        return  ResultUtils.success();
    }
}
