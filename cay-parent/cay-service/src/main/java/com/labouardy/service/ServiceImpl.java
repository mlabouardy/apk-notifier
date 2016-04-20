package com.labouardy.service;

import java.util.ArrayList;
import java.util.Collection;

import com.labouardy.api.Service;
import com.labouardy.model.APK;
import com.labouardy.model.Device;


public class ServiceImpl implements Service{
	private Collection<Device> devices;
	private GCM gcm;
	
	public ServiceImpl(){
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
