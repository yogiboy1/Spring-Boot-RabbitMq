package com.yohan.learnrabbit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yohan.learnrabbit.sender.User;

@RestController
@RequestMapping("/api")
public class restsendjson {
	
	private jsonProducer jsonProducer;

	public restsendjson(jsonProducer jsonProducer) {
		this.jsonProducer= jsonProducer;
	}
	
	@GetMapping("/publishjson")
	public ResponseEntity<String> sendmessage(@RequestBody User user){
		jsonProducer.jsonsend(user);
		return ResponseEntity.ok("Message  json has been sent to rabbit MQ...");
	}
	
}