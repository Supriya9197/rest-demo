package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication 
public class RestFsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestFsApplication.class, args); // used to bootstrap the spring app
	}

}

/*@SpringBootApplication : @EnableAutoconfiguration : used to activate the auto-configuration
 * @ComponentScan : 
 * @Configuration: allow to register beans in the context
 */
