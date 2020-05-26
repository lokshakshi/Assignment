package com.mindbowser.demo;

import java.sql.*;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mindbowser.controller.AdminManagerController;



@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mindbowser.controller", "com.mindbowser.service"})
@EnableJpaRepositories("com.mindbowser.repository")
@EntityScan("com.mindbowser.model")
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("SpringApplication Starts");

	}

}
