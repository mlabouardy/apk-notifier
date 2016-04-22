package com.labouardy.resource;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.labouardy.model.Device;
import com.labouardy.model.Message;
import com.labouardy.repository.DeviceRepository;

@RequestMapping("devices")
@RestController
public class DeviceResource {
	
	private DeviceRepository deviceRepository;
	
	@Autowired
	public DeviceResource(DeviceRepository deviceRepository) {
		this.deviceRepository=deviceRepository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public Collection<Device> getDevices(){
		return deviceRepository.findAll();
	}
	
	@RequestMapping(value="subscribe", method=RequestMethod.POST)
	public ResponseEntity<Message> subscribe(@RequestBody Device device){
		deviceRepository.save(device);
		return new ResponseEntity<Message>(new Message(true), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="unsubscribe/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Message> subscribe(@PathVariable("id") Long id){
		deviceRepository.delete(id);
		return new ResponseEntity<Message>(new Message(true), HttpStatus.ACCEPTED);
	}
	
	
}
