package com.labouardy;

import com.labouardy.model.APK;
import com.labouardy.server.Service;

public interface APKObservable {
	public void notifyServices(APK apk);
	public void subscribe(Service service);
	public void unsubscribe(Service service);
}
