package com.beilie.test.config;

import com.beilie.core.security.interceptor.CookieInjectRequestInterceptor;
import com.beilie.core.security.interceptor.JWTInjectRequestInterceptor;
import feign.Feign;
import feign.RequestInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ConditionalOnClass({ Feign.class })
public class FeignConfigurer {

	@Bean
	@Scope("prototype")
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}

	@Bean
	public RequestInterceptor getCookieInterceptor() {
		return new CookieInjectRequestInterceptor();
	}

	@Bean
	public RequestInterceptor getJWTInterceptor() {
		return new JWTInjectRequestInterceptor();
	}
}
