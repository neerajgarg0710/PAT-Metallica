package com.sapient.metallica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sapient.metallica.filters.ErrorFilter;
import com.sapient.metallica.filters.PostFilter;
import com.sapient.metallica.filters.PreFilter;
import com.sapient.metallica.filters.RouteFilter;

@EnableZuulProxy
@SpringBootApplication
public class MetallicaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MetallicaServiceApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}

}