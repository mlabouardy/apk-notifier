package com.labouardy.server;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.labouardy.model.APK;
import com.labouardy.model.Device;

@Component
public class GCM {
	
	@Value("${cay.apk.key}")
	private String API_KEY;
	
	private static final Logger logger=Logger.getLogger(GCM.class.getName());
	private static final String PACKAGE_KEY="package";
	private static final String URL_KEY="url";
	private static final String VERSION_KEY="version";
	private static final int RETRY_TIMES=1;
	
	public void sendNotification(Device device, APK apk){
		System.out.println("Senf notification "+API_KEY);
		final Sender sender=new Sender(API_KEY);
		final Message message = new Message.Builder()
								    .addData(PACKAGE_KEY, apk.getPackageName())
								    .addData(URL_KEY, apk.getUrl())
								    .addData(VERSION_KEY, apk.getVersion())
								    .build();
		final Result result;
		try {
			result = sender.send(message, device.getId(), RETRY_TIMES);
			logger.debug(result.getSuccess()+" "+result.getFailure());
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}

}
