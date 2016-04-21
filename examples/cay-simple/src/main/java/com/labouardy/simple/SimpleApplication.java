package com.labouardy.simple;

import java.io.IOException;
import java.util.stream.IntStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.labouardy.api.EnableApkNotifier;
import com.labouardy.model.Device;
import com.labouardy.repository.FolderWatcher;
import com.labouardy.repository.Watcher;
import com.labouardy.service.ServiceImpl;

@EnableApkNotifier
@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		ConfigurableApplicationContext ctx=SpringApplication.run(SimpleApplication.class, args);
		ServiceImpl service=new ServiceImpl();
		IntStream.iterate(1, e -> e+1)
		         .limit(5)
		         .forEach(e -> service.addDevice(new Device(String.valueOf(e))));
		FolderWatcher watcher=ctx.getBean(FolderWatcher.class);
		watcher.subscribe(service);
		watcher.monitor();
	}
}
