package com.labouardy.api;

import com.labouardy.model.APK;

public interface APKObservable {
	public void notifyServices(APK apk);
	public void subscribe(Service service);
	public void unsubscribe(Service service);
}
