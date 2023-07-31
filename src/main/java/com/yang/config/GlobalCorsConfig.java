package com.yang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域访问配置
 */
@Configuration
public class GlobalCorsConfig {
  @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    // corsConfig.addAllowedOrigin("*"); // 允许所有来源跨域访问
    corsConfig.addAllowedOriginPattern("*");
    corsConfig.addAllowedMethod("*"); // 允许所有HTTP方法跨域访问
    corsConfig.addAllowedHeader("*"); // 允许所有请求头跨域访问
    corsConfig.setAllowCredentials(true); // 允许发送Cookie跨域
    corsConfig.setMaxAge(3600L); // 预检请求的有效期，单位为秒

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);

    return new CorsFilter(source);
  }
}
