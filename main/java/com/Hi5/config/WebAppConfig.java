package com.Hi5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
@EnableWebMvc 
@ComponentScan(basePackages="com.Hi5")
public class WebAppConfig extends WebMvcConfigurerAdapter 
{
	 public WebAppConfig()
	 {
	    System.out.println(">>>>>WebAppConfig class is loaded and instantiated<<<<<<");
	 }
	 @Bean(name="multipartResolver")
		public CommonsMultipartResolver multipartResolver() 
	 {
		 System.out.println(">>>>>>Commons multipart resolver class loaded<<<<<<<<");
	   return new CommonsMultipartResolver();
     }
}

