package qcadmin.auth.service;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import qcadmin.auth.enums.AuthEnums;
import qcadmin.auth.exception.AuthException;
import qcadmin.auth.model.AuthToken;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: qcadmin_server
 * @description:
 * @author: NieMiao
 * @create: 2019-04-11 15:30
 **/
@Service
@Transactional
public class AuthService {

    @Value("${auth.tokenValiditySeconds}")
    int tokenValiditySeconds;

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RestTemplate restTemplate;

    /**
    * @Description: 申请token，并存入redis
    * @Param: [clientId, clientSecret, username, password]
    * @return: qcadmin.auth.model.AuthToken
    * @Author: NieMiao
    * @Date: 2019/4/11
    */
    public AuthToken login(String clientId, String clientSecret, String username, String password) {
        //请求token
        AuthToken authToken = this.applyToken(clientId,clientSecret,username,password);
        if (null == authToken){
            throw new AuthException(AuthEnums.TOKEN_APPLY_FAIL);
        }
        //获取access_token,存入redis
        String access_token = authToken.getAccess_token();
        String token = JSON.toJSONString(authToken);
        boolean result =  this.saveToken(access_token,token,tokenValiditySeconds);
        //判断是否存入成功
        if (!result){
            throw new AuthException(AuthEnums.TOKEN_SAVE_FAIL);
        }
        return authToken;
    }


    /**
    * @Description: 向springSecurity申请token
    * @Param: [clientId, clientSecret, username, password]
    * @return: qcadmin.auth.model.AuthToken
    * @Author: NieMiao
    * @Date: 2019/4/11
    */
    private AuthToken applyToken(String clientId, String clientSecret, String username, String password) {

        //服务请求地址，先使用固定写法，后面改成从eureka获取ip
        String url = "http://localhost:9002/auth/oauth/token";
        LinkedMultiValueMap<String,String> headers = new LinkedMultiValueMap<>();

        //获取客户端id，secret 经过base64编码后的字符串，用于客户端验证
        String string = clientId+":"+clientSecret;
        byte[] bytes = Base64Utils.encode(string.getBytes());
        String httpBasic = "Basic "+new String(bytes);
        headers.add("Authorization",httpBasic);

        //定义body
        LinkedMultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        body.add("grant_type","password");
        body.add("username",username);
        body.add("password",password);

        //封装header和body
        HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<>(body,headers);

        //设置restTemplate远程调用时候，对400和401不让报错，正确返回数据
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                if(response.getRawStatusCode()!=400 && response.getRawStatusCode()!=401){
                    super.handleError(response);
                }
            }
        });

        ResponseEntity<Map> entity = restTemplate.exchange(url, HttpMethod.POST, httpEntity, Map.class);
        Map entityBody = entity.getBody();
        //判断返回的
        if(entityBody.get("access_token")==null ||
                entityBody.get("refresh_token")==null ||
                    entityBody.get("jti") == null) {
            //解析springSecurity返回的错误
            if (entityBody != null && entityBody.get("error_description") != null) {
                String error_description = (String) entityBody.get("error_description");
                if (error_description.indexOf("UserDetailsService returned null") >= 0) {
                    throw new AuthException(AuthEnums.ACCOUNT_NOT_EXISTS);
                }else if (error_description.indexOf("坏的凭证") >= 0){
                    throw new AuthException(AuthEnums.AUTH_CREDENTIAL_ERROR);
                }
            }
            return null;
        }
        AuthToken authToken = new AuthToken();
        authToken.setAccess_token((String) entityBody.get("jti"));//用户身份令牌
        authToken.setRefresh_token((String) entityBody.get("refresh_token"));//刷新令牌
        authToken.setJwt_token((String) entityBody.get("access_token"));//jwt令牌
        return authToken;
    }


    /**
    * @Description: 将token存入redis
    * @Param: [access_token, token, tokenValiditySeconds]
    * @return: boolean
    * @Author: NieMiao
    * @Date: 2019/4/11
    */
    private boolean saveToken(String access_token, String token, int tokenValiditySeconds) {
        String key = "user_token"+access_token;
        redisTemplate.boundValueOps(key).set(token,tokenValiditySeconds, TimeUnit.SECONDS);
        Long expire = redisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire>0;
    }
}
