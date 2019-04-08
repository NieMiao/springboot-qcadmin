package qcadmin.auth.api;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import qcadmin.auth.model.LoginRequest;
import qcadmin.common.utils.ResultUtils;

/**
 * @program: springboot-com.qcadmin
 * @description: 认证服务接口
 * @author: NieMiao
 * @create: 2019-03-28 11:52
 **/
@RestController
@Api(description = "/认证服务接口")
@RequestMapping("/v1/auth")
public class AuthController {



    @PostMapping("/login")
    public ResultUtils login(@RequestParam(name = "clientId") String clientId,
                             @RequestBody LoginRequest loginRequest){
        return null;

    }

}
