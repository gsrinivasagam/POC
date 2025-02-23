package com.ganesh.redis.publisher.controller;

import com.ganesh.redis.model.SystemMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublishController {

    @Autowired
    private JmsTemplate jmsTemplate;


    @PostMapping("/publishMessage")
    public ResponseEntity publishMessage(@RequestBody SystemMessage systemMessage){
        try {
            jmsTemplate.convertAndSend("bridgingcode-queue",systemMessage);

            return new ResponseEntity("Sent", HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
