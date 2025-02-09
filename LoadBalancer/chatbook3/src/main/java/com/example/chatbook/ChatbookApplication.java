package com.example.chatbook;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/chat-application")
public class ChatbookApplication {

	@Value("${server.port}")
	private String port;

	@GetMapping("/chat")
	public String chatNow(){
		return "the server is up on port"+port;
	}
	public static void main(String[] args) {
		SpringApplication.run(ChatbookApplication.class, args);
	}

}
