package com.labouardy.simple;

import java.io.IOException;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.labouardy.model.Device;
import com.labouardy.repository.FolderWatcher;
import com.labouardy.service.ServiceImpl;

@EnableScheduling
@ComponentScan({"com.labouardy.repository"})
@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext ctx=SpringApplication.run(SimpleApplication.class, args);

		System.out.println("workign");
		ServiceImpl service=new ServiceImpl();
		IntStream.iterate(1, e -> e+1)
		         .limit(5)
		         .forEach(e -> service.addDevice(new Device(String.valueOf(e))));
		FolderWatcher watcher=ctx.getBean(FolderWatcher.class);
		watcher.subscribe(service);
		watcher.monitor();
	}
}
