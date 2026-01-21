package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class NoCacheInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {

			@Override
			public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView mav) {

				res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
				res.setHeader("Pragma", "no-cache");
				res.setDateHeader("Expires", 0);
			}
		});
	}
}
