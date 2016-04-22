package com.labouardy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.labouardy.model")
@EnableJpaRepositories("com.labouardy.repository")
@ComponentScan({"com.labouardy.resource","com.labouardy.admin"})
public class CayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CayServerApplication.class, args);
	}
}
