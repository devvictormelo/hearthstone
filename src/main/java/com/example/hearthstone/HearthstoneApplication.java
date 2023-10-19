package com.example.hearthstone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class HearthstoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(HearthstoneApplication.class, args);
	}

}
