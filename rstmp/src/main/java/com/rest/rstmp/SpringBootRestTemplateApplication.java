package com.rest.rstmp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import com.rest.rstmp.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class SpringBootRestTemplateApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootRestTemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestTemplateApplication.class, args);
	}
	

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
		

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	
	  @Bean public RestTemplate restTemplate() {
	  
	  var factory = new SimpleClientHttpRequestFactory();
	  factory.setConnectTimeout(3000); factory.setReadTimeout(3000); return new
	  RestTemplate(factory); }
	  
	 	
		
		
	


}