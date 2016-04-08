package com.toien.discover.logback.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = { "com.toien.discover.logback.web" })
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
//	@Bean
//	public ViewResolver getViewResolver() {
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/");
//		resolver.setSuffix(".jsp");
//		return resolver;
//	}
}
