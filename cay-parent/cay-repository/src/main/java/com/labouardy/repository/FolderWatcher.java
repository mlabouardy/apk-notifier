package com.labouardy.repository;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.labouardy.model.APK;

@Component
public class FolderWatcher extends Watcher{
	
	@Override
	@Scheduled(cron="0 0/2 * * * ?")
	public void monitor(){
		System.out.println("check");
		APK apk=new APK();
		notifyServices(apk);
	}


}
