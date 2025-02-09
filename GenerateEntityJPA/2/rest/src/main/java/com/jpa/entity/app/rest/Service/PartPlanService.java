package com.jpa.entity.app.rest.Service;

import com.jpa.entity.app.rest.Models.PartPlanResponse;
import com.jpa.entity.app.rest.PrimaryEntity.Plan;
import com.jpa.entity.app.rest.PrimaryRepo.PlanRepository;
import com.jpa.entity.app.rest.SecondaryEntity.Part;
import com.jpa.entity.app.rest.SecondaryRepo.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PartPlanService {

    @Autowired
    private PlanRepository planRepo;

    @Autowired
    private PartRepository partRepo;

    public List<PartPlanResponse> getPartPlanResponses() {
        List<Plan> plans = planRepo.findAll();
        List<Part> parts = partRepo.findAll();
        List<PartPlanResponse> responseList = new ArrayList<>();

        // Assuming each Plan can be associated with each Part (simple combination logic)
        for (Plan plan : plans) {
            for (Part part : parts) {
                PartPlanResponse response = new PartPlanResponse(
                        plan.getPlanId(),
                        plan.getPlanName(),
                        plan.getPlanStatus(),
                        part.getPartId(),
                        part.getPartName(),
                        part.getPartNo(),
                        part.getPartCHG()
                );
                responseList.add(response);
            }
        }

        return responseList;
    }
}
