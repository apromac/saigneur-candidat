package com.apromac.saigneur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients("com.apromac.saigneur.proxy")
//@EnableEurekaClient


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.apromac.saigneur")
public class SaigneurCandidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaigneurCandidatApplication.class, args);
	}

}
