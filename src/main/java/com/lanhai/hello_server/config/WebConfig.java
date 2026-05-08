//package com.lanhai.hello_server.config;
//
//import com.lanhai.hello_server.interceptor.AuthInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
////
////    private final AuthInterceptor authInterceptor;
////
////    public WebConfig(AuthInterceptor authInterceptor) {
////        this.authInterceptor = authInterceptor;
////    }
////
////    @Override
////    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(authInterceptor)
////                .addPathPatterns("/**") // 拦截所有请求
////                .excludePathPatterns("/hello", "/user/login"); // 放行部分接口
////    }
//}