package com.labouardy.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.labouardy.config.CayProperties;

@SpringBootApplication
@EnableConfigurationProperties(CayProperties.class)
@EntityScan("com.labouardy.model")
@EnableJpaRepositories("com.labouardy.repository")
@ComponentScan({"com.labouardy.resource","com.labouardy.admin","com.labouardy.service","com.labouardy.config"})
public class CayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CayServerApplication.class, args);
	}
}
