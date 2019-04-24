package qcadmin.auth.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Order(-1)
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().mvcMatchers(HttpMethod.POST,"/userLogin");
        web.ignoring().antMatchers(HttpMethod.POST,"/userLogout");
        web.ignoring().antMatchers("/swagger-ui.html","/v2/api-docs","/swagger-resources/configuration/ui"
        ,"/swagger-resources","/swagger-resources/configuration/security","/swagger-resources/**");
        /**
         *    "/swagger-ui.html",
         *                 "/v2/api-docs", // swagger api json
         *                 "/swagger-resources/configuration/ui", // 用来获取支持的动作
         *                 "/swagger-resources", // 用来获取api-docs的URI
         *                 "/swagger-resources/configuration/security", // 安全选项
         *                 "/swagger-resources/**"
         */
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }
    //采用bcrypt对密码进行编码
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .httpBasic().and()
                .formLogin()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
