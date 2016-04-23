package com.labouardy.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.labouardy.model.Message;

@RequestMapping("github")
@RestController
public class GithubResource {
	
	@RequestMapping(value="notify", method=RequestMethod.POST)
	public ResponseEntity<Message> subscribe(@RequestBody String message){
		System.out.println(message);
		return new ResponseEntity<Message>(new Message(true), HttpStatus.CREATED);
	}

}
