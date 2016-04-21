package com.labouardy.repository;

import org.jboss.logging.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.labouardy.model.APK;

@Component
public class FolderWatcher extends Watcher{
	
	private static final Logger logger=Logger.getLogger(FolderWatcher.class.getName());
	
	@Override
	@Scheduled(cron="0 0/2 * * * ?")
	public void monitor(){
		logger.debug("Checking for new apk");
		APK apk=new APK();
		notifyServices(apk);
	}


}
