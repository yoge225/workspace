package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;




@SpringBootApplication
@EntityScan("com.user.info.model")
@ComponentScan({"com.user.info.service","com.user.info.controller","com.user.info.config"})
@EnableJpaRepositories("com.user.info.dao")
@EnableAutoConfiguration
@Configuration
public class UserRegistrationApplication extends SpringBootServletInitializer {

	
	private static final Class<UserRegistrationApplication> applicationClass = UserRegistrationApplication.class;
    private static final Logger log = LoggerFactory.getLogger(applicationClass);

	public static void main(String[] args) {
		SpringApplication.run(UserRegistrationApplication.class, args);
	}
	

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }  

}
