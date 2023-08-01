package com.example.customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CustomersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersApplication.class, args);


	}

	@Bean
	public FilterRegistrationBean<TokenFilter> tokenFilter() {
		FilterRegistrationBean<TokenFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new TokenFilter());
		registrationBean.addUrlPatterns("/api/*"); // Specify the URL patterns you want to apply the filter to.
		return registrationBean;
	}

//	@Bean
//	public WebMvcConfigurer configurer(){
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry reg){
//				reg.addMapping("/api/*").allowedOrigins("*").allowedHeaders("*");
//			}
//		};
//	}
}
