package com.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com")
@EnableJpaRepositories
@EntityScan
public class ProductRestApiUsingSpringDataApplication {

	public static void main(String[] args) {

        SpringApplication.run(ProductRestApiUsingSpringDataApplication.class, args);
	}

}
