package com.labouardy.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="cay")
public class CayProperties {
	
	@NotNull
    @Valid
	private Server server;
	
	@NotNull
    @Valid
	private Git git;
	
	@NotNull
    @Valid
	private API api;
	
	public static class API{
		
		@NotEmpty
		private String key;

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}
		
	}
	
	public static class Server {
		
		@NotEmpty
		private String remoteAddress;

		public String getRemoteAddress() {
			return remoteAddress;
		}

		public void setRemoteAddress(String remoteAddress) {
			this.remoteAddress = remoteAddress;
		}
	}
	
	public static class Git {
		
		@NotEmpty
		private String username;
		
		@NotEmpty
		private String password;
		
		@NotEmpty
		private String repository;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRepository() {
			return repository;
		}

		public void setRepository(String repository) {
			this.repository = repository;
		}
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Git getGit() {
		return git;
	}

	public void setGit(Git git) {
		this.git = git;
	}
}
