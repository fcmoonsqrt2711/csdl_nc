package com.javaweb.QLktx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class QLktxApplication {
	public static void main(String[] args) {
		SpringApplication.run(QLktxApplication.class, args);
	}

}
