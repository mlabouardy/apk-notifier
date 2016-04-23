package com.labouardy.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.labouardy.config.CayProperties;

@EnableConfigurationProperties(CayProperties.class)
@EntityScan("com.labouardy.model")
@EnableJpaRepositories("com.labouardy.repository")
@ComponentScan({"com.labouardy.resource","com.labouardy.admin","com.labouardy.service","com.labouardy.config"})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableCayServer {

}
