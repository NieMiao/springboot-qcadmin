package qcadmin.auth.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import qcadmin.auth.enums.AuthEnums;
import qcadmin.auth.exception.AuthException;
import qcadmin.auth.model.AuthToken;
import qcadmin.auth.model.LoginRequest;
import qcadmin.auth.service.AuthService;
import qcadmin.auth.utils.CookieUtil;
import qcadmin.common.VO.ResultVO;
import qcadmin.common.utils.ResultUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @program: springboot-com.qcadmin
 * @description: 认证服务接口
 * @author: NieMiao
 * @create: 2019-03-28 11:52
 **/
@Api(description = "认证服务接口")
@RestController
@RequestMapping("/")
public class AuthController {

    @Autowired
    AuthService authService;

    @Value("${auth.clientId}")
    String clientId;

    @Value("${auth.clientSecret}")
    String clientSecret;

    @Value("${auth.cookieDomain}")
    String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;



    @ApiOperation(value = "用户登录接口")
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

        // 将令牌存入cookie，之后再做
        this.saveCookie(authToken.getAccess_token());

        return ResultUtils.success(authToken);
    }


    @ApiOperation(value = "用户注销接口")
    @PostMapping("/userLogout")
    public ResultVO logout(){
        String tokenFromCookie = getTokenFromCookie();
        //删除redis中的token
        authService.delToken(tokenFromCookie);
        //清除cookie中的token
        this.clearCookie(tokenFromCookie);
        return ResultUtils.success();
    }



    //将令牌存储到cookie
    private void saveCookie(String token){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,cookieDomain,"/","uid",token,cookieMaxAge,false);
    }

    //从cookie中删除令牌
    private void clearCookie(String token){
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        //HttpServletResponse response,String domain,String path, String name, String value, int maxAge,boolean httpOnly
        CookieUtil.addCookie(response,cookieDomain,"/","uid",token,0,false);

    }

    //取出cookie中的身份令牌
    private String getTokenFromCookie(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String, String> map = CookieUtil.readCookie(request, "uid");
        if(map!=null && map.get("uid")!=null){
            String uid = map.get("uid");
            return uid;
        }
        return null;
    }
}
