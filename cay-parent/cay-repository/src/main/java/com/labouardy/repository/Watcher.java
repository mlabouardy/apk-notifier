package com.labouardy.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import com.labouardy.api.APKObservable;
import com.labouardy.api.ApkMonitor;
import com.labouardy.api.Service;
import com.labouardy.model.APK;

@Component
public abstract class Watcher implements APKObservable, ApkMonitor{
	private Collection<Service> services;
	
	public Watcher(){
		services=new ArrayList<Service>();
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
