package com.labouardy.service;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Base64;
import java.util.EnumSet;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.kohsuke.github.GHEvent;
import org.kohsuke.github.GitHub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.labouardy.model.WebHookConfig;

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
	
	private RestTemplate restTemplate=new RestTemplate();
	
	private final static Logger logger=Logger.getLogger(WebHookService.class.getName());
	
	private final static String JSON_KEY="json";

	@Override
	public void run(String... arg0) throws Exception {
		/*int id=GitHub.connectUsingPassword(username, password)
				     .getRepository(repository)
				     .createWebHook(new URL(remoteAddress+"/github/notify"),EnumSet.of(GHEvent.RELEASE))
				     .getId();
		
		WebHookConfig config=new WebHookConfig();
		config.setUrl(remoteAddress+"/github/notify");
		config.setContent(JSON_KEY);

		updateWebHook(id, config);
		
		logger.info("Webhook created : "+remoteAddress+"/github/notify");*/
	}
	
	public void updateWebHook(int id, WebHookConfig config) throws RestClientException, JsonProcessingException{
		String url="https://api.github.com/repos/"+repository+"/hooks/"+id;
		//Set timeout for HTTP Method PATCH
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		restTemplate.setRequestFactory(requestFactory);
		
		//Basic Authentication
		String plainCreds = username+":"+password;
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, true);
		
		restTemplate.exchange(url, HttpMethod.PATCH, new HttpEntity<String>(mapper.writeValueAsString(config),headers), String.class);
	}

}
