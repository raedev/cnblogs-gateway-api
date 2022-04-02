package com.cnblogs.gateway.web.config;

import com.cnblogs.gateway.web.interceptor.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web配置
 * @author RAE
 * @date 2022/03/21
 * Copyright (c) https://github.com/raedev All rights reserved.
 */
@Configuration
@EnableConfigurationProperties(CnblogsProperties.class)
@Slf4j
public class WebConfig implements WebMvcConfigurer {

    private final CnblogsProperties mCnblogsProperties;

    public WebConfig(CnblogsProperties cnblogsProperties) {
        this.mCnblogsProperties = cnblogsProperties;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(new RequestInterceptor(mCnblogsProperties));
        registration.excludePathPatterns("/error");
    }
}
