package com.example.demo.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RestTemplateService {

    private static final String get_all_employees = "http://localhost:8080/users";
    RestTemplate restTemplate = new RestTemplate();
    public ResponseEntity<String> allEmployee(){

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity("paramaters",headers);
        ResponseEntity<String> response = restTemplate.exchange(get_all_employees, HttpMethod.GET, entity, String.class);
        return response;
    }
}
