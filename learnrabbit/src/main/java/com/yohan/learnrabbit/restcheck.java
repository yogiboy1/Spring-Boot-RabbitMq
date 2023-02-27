package com.yohan.learnrabbit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class restcheck {

	private Runner tut1Sender;

	public restcheck(Runner tut1Sender) {
		this.tut1Sender = tut1Sender;
	}
	
	@GetMapping("/publish")
	public ResponseEntity<String> sendmessage(@RequestParam("string") String message){
		tut1Sender.sendmessage(message);
		return ResponseEntity.ok("Message has been sent to rabbit MQ...");
	}
	
}
