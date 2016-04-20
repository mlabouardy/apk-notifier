package com.labouardy.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.labouardy.api.APKObservable;
import com.labouardy.api.Service;
import com.labouardy.model.APK;

@Component
public class FolderWatcher implements APKObservable{
	private Collection<Service> services;

	public FolderWatcher(){
		services=new ArrayList<Service>();
	}

	@Scheduled(cron="0 0/2 * * * ?")
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
