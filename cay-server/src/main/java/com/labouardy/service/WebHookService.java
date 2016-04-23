package com.labouardy.service;

import java.net.URL;
import java.util.EnumSet;

import org.apache.log4j.Logger;
import org.kohsuke.github.GHEvent;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class WebHookService implements CommandLineRunner{
	
	@Value("${cay.git.username}")
	private String username;
	
	@Value("${cay.git.password}")
	private String password;
	
	@Value("${cay.git.repository}")
	private String repository;
	
	@Value("${cay.server.remoteAddress}")
	private String remoteAddress;
	
	private final static Logger logger=Logger.getLogger(WebHookService.class.getName());

	@Override
	public void run(String... arg0) throws Exception {
		GitHub.connectUsingPassword(username, password)
	      .getRepository(repository)
	      .createWebHook(new URL(remoteAddress),EnumSet.of(GHEvent.PUSH));
		logger.info("Webhook created : "+remoteAddress+"/github/notify");
	}

}
