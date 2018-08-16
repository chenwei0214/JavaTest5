package com.hand;

import java.util.List;

import com.hand.infra.config.CustomHandlerMethodArgumentResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@MapperScan(value = {"com.hand.infra.mapper"})
@SpringBootApplication
public class Application extends WebMvcConfigurationSupport {

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // 注册的参数分解器
        argumentResolvers.add(new CustomHandlerMethodArgumentResolver());
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
