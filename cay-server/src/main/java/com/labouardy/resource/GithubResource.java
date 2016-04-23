package com.labouardy.resource;

import java.io.IOException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.labouardy.converter.ReleaseConverter;
import com.labouardy.model.Apk;
import com.labouardy.model.Release;

@RequestMapping("github")
@RestController
public class GithubResource {
	
	private static final String RELEASE_KEY="release";
	
	@RequestMapping(value="notify", method=RequestMethod.POST)
	public ResponseEntity<Apk> subscribe(@RequestBody String message) throws JsonParseException, JsonMappingException, IOException{
		JSONObject data=new JSONObject(message);
		JSONObject releaseWrapper=data.getJSONObject(RELEASE_KEY);
		ObjectMapper mapper=new ObjectMapper();
		Release release=mapper.readValue(releaseWrapper.toString(), Release.class);
		Apk apk=ReleaseConverter.convertToApk().apply(release);
		return new ResponseEntity<Apk>(apk, HttpStatus.CREATED);
	}

}
