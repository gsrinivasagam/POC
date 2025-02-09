package com.example.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class RunAsynchDemo {

    public void saveEmployee(File jsonFile){

        ObjectMapper mapper = new ObjectMapper();
        CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Employee> employees = (List<Employee>) mapper.readValue(jsonFile, new TypeReference<Employee>() {});
                    System.out.println("Thread -- "+Thread.currentThread().getName());
                    employees.stream().forEach(System.out::println);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
