package com.jpa.entity.app.rest.Controller;


import com.jpa.entity.app.rest.Models.PartPlanResponse;
import com.jpa.entity.app.rest.PrimaryEntity.Plan;
import com.jpa.entity.app.rest.PrimaryRepo.PlanRepository;
import com.jpa.entity.app.rest.Repo.UserRepo;
import com.jpa.entity.app.rest.SecondaryEntity.Part;

import com.jpa.entity.app.rest.SecondaryRepo.PartRepository;
import com.jpa.entity.app.rest.Service.PartPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    //@Autowired
    //private UserRepo userRepo;

    @Autowired
    private PlanRepository planRepo;

    @Autowired
    private PartRepository partRepo;

    @Autowired
    private PartPlanService partPlanService;

    @GetMapping(value ="/")
    public String getPage(){
        return "welcome";
    }

    @GetMapping(value = "/plans")
    public List<Plan> getUsers(){
        return planRepo.findAll();
    }

    @GetMapping(value = "/parts")
    public List<Part> getOrders(){
        return partRepo.findAll();
    }

    @GetMapping(value = "/parts-and-plans")
    public List<PartPlanResponse> getPartPlans() {
        List<PartPlanResponse> partPlanResponse = partPlanService.getPartPlanResponses();
        return partPlanResponse;
    }






}
