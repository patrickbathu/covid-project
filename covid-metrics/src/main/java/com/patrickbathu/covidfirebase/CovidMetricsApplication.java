package com.patrickbathu.covidfirebase;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableRabbit
@EnableFeignClients
@EnableCaching
@SpringBootApplication
public class CovidMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidMetricsApplication.class, args);
	}

}
