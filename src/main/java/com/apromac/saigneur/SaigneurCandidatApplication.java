package com.apromac.saigneur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@EnableWebMvc
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients("com.apromac.saigneur")
public class SaigneurCandidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaigneurCandidatApplication.class, args);
	}

}
