package com.kj.review.Interceptor;

import com.kj.review.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author kj
 * @date 2023/3/4
 * @apiNote
 */
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginInterceptor(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/**") //配置需要拦截的路径
                .excludePathPatterns("/user/login","/user/save","/swagger-resources/**"
                        ,"/webjars/**","/v2/**", "/swagger-ui.html/**");
                // .excludePathPatterns(
                //         "/user/login","/user/{id}","/swagger-resources/**",
                //         "/webjars/**", "/v2/**", "/swagger-ui.html/**"); //配置不需要拦截的路径
    }
}
