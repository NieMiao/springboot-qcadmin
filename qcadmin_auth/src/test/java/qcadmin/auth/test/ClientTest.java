package qcadmin.auth.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: springboot-qcadmin
 * @description: 客户端测试
 * @author: NieMiao
 * @create: 2019-03-28 17:08
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClientTest {

    @Test
    public static void main(String[] args) {
        String string = new String("qcadmin");

        String encode = new BCryptPasswordEncoder().encode(string);

        System.out.println(encode);
    }

}


