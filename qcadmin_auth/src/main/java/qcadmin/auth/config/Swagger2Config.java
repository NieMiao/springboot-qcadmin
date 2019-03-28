package qcadmin.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: springboot-com.qcadmin
 * @description: swagger配置类
 * @author: NieMiao
 * @create: 2019-03-28 14:22
 **/
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = "qcadmin.auth.api")
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(""))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("qcadmin-auth 认证服务api")
                .description("qcadmin-auth 认证服务api")
                .termsOfServiceUrl("http://127.0.0.1:8080/")
                .contact(new Contact("NieMiao",null,"905336559@qq.com"))
                .version("1.0.0")
                .build();
    }
}
