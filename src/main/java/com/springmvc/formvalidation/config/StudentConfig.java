package com.springmvc.formvalidation.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.springmvc.formvalidation.service.StudentService;
import com.springmvc.formvalidation.service.StudentServiceImpl;
import com.springmvc.formvalidation.dao.*;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springmvc.formvalidation")
public class StudentConfig {
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver =new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	 @Bean
	    public MessageSource messageSource() {
	        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	        messageSource.setBasename("messages");
	        return messageSource;
	    }

}
