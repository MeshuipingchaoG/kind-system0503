package com.chen.config;

import com.github.pagehelper.PageInterceptor;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageHelperInterceptor {
    @Bean
    public Interceptor[] plugins(){
        return new Interceptor[]{new PageInterceptor()};
    }
}
