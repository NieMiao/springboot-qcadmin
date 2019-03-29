package qcadmin.auth.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @program: springboot-com.qcadmin
 * @description: redis测试
 * @author: NieMiao
 * @create: 2019-03-28 11:39
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate template;
    @Test
    public void redisTest(){

        String token = "e9fc346f-9431-4f21-a409-9ea149c89f4c";
        Map map = new HashMap();
        map.put("name","nie");
        template.boundValueOps(token).set(JSON.toJSONString(map),1000, TimeUnit.SECONDS);
        Long expire = template.getExpire(token);
        String s = template.opsForValue().get(token);
        System.out.println(s);
    }
}
