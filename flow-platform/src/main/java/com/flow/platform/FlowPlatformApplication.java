package com.flow.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FlowPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowPlatformApplication.class, args);
	}

	/**
	 * 配置跨域支持
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // 允许所有路径
						.allowedOrigins("*") // 允许所有来源
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的 HTTP 方法
						.allowedHeaders("*") // 允许所有请求头
						.allowCredentials(false) // 不允许携带凭证
						.maxAge(3600); // 预检请求缓存时间（秒）
			}
		};
	}

}
