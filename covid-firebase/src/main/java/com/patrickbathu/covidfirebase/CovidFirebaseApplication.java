package com.patrickbathu.covidfirebase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CovidFirebaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidFirebaseApplication.class, args);
	}

}
