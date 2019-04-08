package qcadmin.auth.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.RsaSigner;
import org.springframework.security.jwt.crypto.sign.RsaVerifier;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: springboot-qcadmin
 * @description: 测试类
 * @author: NieMiao
 * @create: 2019-03-27 14:51
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDemo {

    @Test
    public void testCreateJwt(){

        //密码库文件名
        String path = "qcadmin.keystore";

        //密码库密码
        String password = "qadmian";
        //获得文件路径
        ClassPathResource classPathResource = new ClassPathResource(path);

        //密钥别名
        String alias = "qckey";

        //密钥访问密码
        String alias_password = "qcadmin";

        //密钥工厂
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(classPathResource, alias_password.toCharArray());
        //密钥对(公钥和私钥)
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias);

        Map<String,String> map = new HashMap<>();
        map.put("name","nie");
        String s = JSON.toJSONString(map);
        //生成jwt令牌
        Jwt encode = JwtHelper.encode(s, new RsaSigner((RSAPrivateKey) keyPair.getPrivate()));

        String encoded = encode.getEncoded();
        System.out.println(encoded);
    }

    @Test
    public void analysisJwt(){
        //公钥
        String publicKey  = "-----BEGIN PUBLIC KEY-----MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0B/FahviVen/2ar0GqWnGos5ufxXwrm2C7M3K536l5eDimYXsaCitBsKWyS0z7iRUTp9g/NF/RlRXD+U8kRdKU6hyOxBk33ZcdBhZKQExD7KHKNAEyY6c19RldSC97pXss9Y6jKGiakDgt9UCjuU0WO9u7S8wOY8LhcZC9dpOZAregs1OhgHRA8RHV23Jdjtrf9540yxI0QYkFO7MhuJ/fwEp0f8qnZ2jeEvE/62CBgRVaZFSdndBUH30EC8mN2h4qhr/1d+Sw3nQVIgUd/qE8s/vaj32GZRrg9gsl71iTNrA1UUD4k6FveLVFOmyesVhxc8AhYvgpowm2VgCpjbqQIDAQAB-----END PUBLIC KEY-----";
        //jwt令牌
        String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJtYW5hZ2VyIiwic2NvcGUiOlsiYXBwIl0sImlkIjoiMSIsImV4cCI6MTU1NDQxNTgyMywiYXV0aG9yaXRpZXMiOlsiMDAxIiwiMDAyIl0sImp0aSI6Ijk4ZDQyNjgyLWYzYWQtNDU5Yi04ZjhiLTgzZTJkZWFlYmIwMyIsImNsaWVudF9pZCI6InFjYWRtaW4ifQ.raD7zZ7D9ytuMN8wiCGcoC4CraTIO-f70K1Aa8NYaZqRpqLRroIlaAWkHX5GUMaC31o4zmkEHqbkq_EDtChPspAt_VajfenSA7MC-86j9BV4cp1vq6UwDcXXAi_YU3FVYN-afWGjF0YNMeVS6ykjOLRY9QyBOw_H522Xtbm44l1Fcg9cma-UpPlZdbFYtnzUClWEqEdYIz3J1_zGHHgsNUZq3YkVKZpbgjg8ki9qo31HgIPwaTevgaZhO8gAs_asDuk6SaST97O3-ZRo-0zasMK_qEtLov73RN6WrX-L_0Kr8JkAQSja_OXMhQ8Y54LsrJDK0Yp4GvuhrvXv6v5hGw";

        Jwt jwt = JwtHelper.decodeAndVerify(token, new RsaVerifier(publicKey));
        //获取jwt令牌中自定义的内容
        String claims = jwt.getClaims();
        System.out.println(claims);
    }
}
