
package com.cts.outreach;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.context.annotation.Bean;

import com.cts.outreach.jwtfilter.JwtFilter;

@SpringBootApplication
public class UserServiceApplication {

	@Bean
	public FilterRegistrationBean jwtFilter() {
		FilterRegistrationBean<JwtFilter> filterRegBean = new FilterRegistrationBean<JwtFilter>();
		filterRegBean.setFilter(new JwtFilter());
		filterRegBean.addUrlPatterns("/user/*");
		return filterRegBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}