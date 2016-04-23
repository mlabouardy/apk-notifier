package com.labouardy.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.labouardy.model.Apk;
import com.labouardy.model.Device;

@Component
public class GCMService {
	
	@Value("${cay.api.key}")
	private String API_KEY;

	private static final Logger logger = Logger.getLogger(GCMService.class.getName());
	private static final String PACKAGE_KEY = "package";
	private static final String URL_KEY = "url";
	private static final String VERSION_KEY = "version";
	private static final String DESC_KEY = "description";
	private static final int RETRY_TIMES = 1;

	public void sendNotification(Device device, Apk apk) {
		logger.info("Send notification to device " + device.getId());

		final Sender sender = new Sender(API_KEY);
		final Message message = new Message.Builder()
				.addData(PACKAGE_KEY, apk.getName())
				.addData(URL_KEY, apk.getUrl())
				.addData(DESC_KEY, apk.getDescription())
				.addData(VERSION_KEY, apk.getTag())
				.build();
		final Result result;
		try {
			result = sender.send(message, device.getRegId(), RETRY_TIMES);
			logger.debug(result.getSuccess() + " " + result.getFailure());
		} catch (IOException e) {
			logger.debug(e.getMessage());
		}
	}
}
