package com.labouardy;

import java.io.IOException;
import java.util.stream.IntStream;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.labouardy.folder.FolderWatcher;
import com.labouardy.model.Device;
import com.labouardy.server.Service;

@EnableScheduling
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext ctx=SpringApplication.run(Application.class, args);
		Service service=new Service();
		IntStream.iterate(1, e -> e+1)
		         .limit(5)
		         .forEach(e -> service.addDevice(new Device(String.valueOf(e))));
		FolderWatcher watcher=ctx.getBean(FolderWatcher.class);
		watcher.subscribe(service);
		watcher.monitor();
	}
}
