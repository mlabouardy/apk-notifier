package com.labouardy.server;

import java.util.ArrayList;
import java.util.Collection;

import com.labouardy.model.APK;
import com.labouardy.model.Device;
import com.labouardy.observer.APKObserver;

public class Service implements APKObserver{
	private Collection<Device> devices;
	private GCM gcm;
	
	public Service(){
		devices=new ArrayList<Device>();
		gcm=new GCM();
	}
	
	@Override
	public void uploaded(APK apk) {
		devices.forEach(device -> gcm.sendNotification(device, apk));
	}
	
	public void addDevice(Device device){
		devices.add(device);
	}

}
