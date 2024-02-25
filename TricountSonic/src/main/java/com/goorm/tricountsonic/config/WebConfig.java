package com.goorm.tricountsonic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.goorm.tricountsonic.interceptor.LoginCheckInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(loginCheckInterceptor())
      .order(1)
      .addPathPatterns("/**")
      .excludePathPatterns("/signup", "/login", "/h2-console/**");
  }

  @Bean
  public LoginCheckInterceptor loginCheckInterceptor() {return new LoginCheckInterceptor();}

}
