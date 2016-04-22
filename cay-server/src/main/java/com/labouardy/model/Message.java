package com.labouardy.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private boolean success;
	
	private Collection<String> errors;
	
	public Message(){
		errors=Collections.emptyList();
	}
	
	public Message(boolean success){
		this.success=success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Collection<String> getErrors() {
		return errors;
	}

	public void setErrors(Collection<String> errors) {
		this.errors = errors;
	}
}
