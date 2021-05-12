package com.shenxian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * 扩展springboot默认springMvc配置
 * @Author: immor
 * @Date: 2021/5/11
 */
@Configuration
//@EnableWebMvc//@EnableWebMvc会全面接管springboot默认的配置 因为@ConditionalOnMissingBean({WebMvcConfigurationSupport.class})
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login.htm").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");

        registry.addViewController("/home/index").setViewName("home/index");
        registry.addViewController("/home/about").setViewName("home/about");
        registry.addViewController("/home/Case").setViewName("home/Case");
        registry.addViewController("/home/contact").setViewName("home/contact");
        registry.addViewController("/home/Introduction").setViewName("home/Introduction");
        registry.addViewController("/home/Product").setViewName("home/Product");
        registry.addViewController("/home/Service").setViewName("home/Service");
    }

    /**
     * 自定义拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/login.htm", "/login.html", "/user/login",
                        "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg", "/**/*.gif", "/**/fonts/*", "/**/*.svg");
    }

    /**
     * 国际化
     * @return
     */
    @Bean(name="localeResolver")
    public LocaleResolver myLocaleResolver() {
        return new MyLocaleResolver();
    }
}
