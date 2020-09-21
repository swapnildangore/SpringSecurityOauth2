/**
 * 
 */
package com.swapnil.learning.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.swapnil.learning.interceptor.LoggingInterceptor;

/**
 * @author Swapnil Dangore
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
    OAuth2ClientProperties oAuth2ClientProperties() {
        return new OAuth2ClientProperties();
    }
	
	@Bean
	public LoggingInterceptor loggingInterceptor() {
	    return new LoggingInterceptor();
	}    
	@Bean
	public WebMvcConfigurer adapter() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addInterceptors(InterceptorRegistry registry) {
	            registry.addInterceptor(loggingInterceptor());
	        }
	        
	        @Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/employees").allowedOrigins("http://localhost:4200");
			}
	    };
	}	
	
}
