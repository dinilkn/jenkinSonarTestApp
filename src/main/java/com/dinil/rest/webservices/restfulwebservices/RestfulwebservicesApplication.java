package com.dinil.rest.webservices.restfulwebservices;

import java.util.Locale;

import javax.tools.DocumentationTool.Location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulwebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulwebservicesApplication.class, args);
	}
	
	@Bean
	public SessionLocaleResolver localeResolver(){
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
		
	}

	/*No need to giv this method implementatin in  spring boot you can configure it is appication.properties*/
//	public ResourceBundleMessageSource  getResourceBundleMessageSource(){
//		
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}
//	
}
