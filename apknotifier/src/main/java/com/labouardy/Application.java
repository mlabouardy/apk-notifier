package com.labouardy;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(Application.class, args);
		/*Service service=new Service();
		IntStream.iterate(1, e -> e+1)
		         .limit(5)
		         .forEach(e -> service.addDevice(new Device(e)));
		FolderWatcher watcher=new FolderWatcher();
		watcher.subscribe(service);
		watcher.monitor();*/
	}
}
