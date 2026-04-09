package com.lanhai.hello_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lanhai.hello_server")
public class HelloServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloServerApplication.class, args);
		System.out.println("Hello Spring");
	}

}
