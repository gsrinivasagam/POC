package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.RestTemplateService;

@RestController
public class RestTemplateController {
    @GetMapping(value ="/")
    public String getPage(){
        return "welcome";
    }

    @Autowired
    private RestTemplateService restTemplateService;
    @GetMapping("/getAllEmployee")
    public ResponseEntity<String> getAllEmployee(){
        System.out.println("get all employees");
        return restTemplateService.allEmployee();
    }
}
