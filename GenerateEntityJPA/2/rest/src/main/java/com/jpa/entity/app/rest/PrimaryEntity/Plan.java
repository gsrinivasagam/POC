package com.jpa.entity.app.rest.PrimaryEntity;

import javax.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;

    private String planName;

    public Plan(Long planId, String planName, String planStatus) {
        this.planId = planId;
        this.planName = planName;
        this.planStatus = planStatus;
    }

    private String planStatus;

    public Plan() {}

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }
}
