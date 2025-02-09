package com.example.grandchildservice.Service;

import org.springframework.stereotype.Service;

@Service
public class GcService {
    public String createHi(){
        return "Hi From Grandchild";
    }
}
