package com.labouardy.folder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.labouardy.model.APK;
import com.labouardy.observer.APKObservable;
import com.labouardy.server.Service;

@Component
public class FolderWatcher implements APKObservable{
	private Collection<Service> services;
	
	public FolderWatcher(){
		services=new ArrayList<Service>();
	}
	
	@Scheduled(cron="* * * * * *")
	public void monitor() throws IOException, InterruptedException{
		System.out.println("check");
		APK apk=new APK();
		notifyServices(apk);
	}

	@Override
	public void notifyServices(APK apk) {
		services.forEach(service -> service.uploaded(apk));
	}

	@Override
	public void subscribe(Service service) {
		services.add(service);
	}

	@Override
	public void unsubscribe(Service service) {
		services.remove(service);
	}

}
