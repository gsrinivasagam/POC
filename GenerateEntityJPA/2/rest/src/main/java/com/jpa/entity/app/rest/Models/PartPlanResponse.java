package com.jpa.entity.app.rest.Models;

public class PartPlanResponse {

    private Long planId;
    private String planName;
    private String planStatus;

    private Long partId;
    private String partName;
    private String partNo;
    private Double partCHG;

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

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public String getPartNo() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo = partNo;
    }

    public Double getPartCHG() {
        return partCHG;
    }

    public void setPartCHG(Double partCHG) {
        this.partCHG = partCHG;
    }

    public PartPlanResponse(Long planId, String planName, String planStatus,
                            Long partId, String partName, String partNo, Double partCHG) {
        this.planId = planId;
        this.planName = planName;
        this.planStatus = planStatus;
        this.partId = partId;
        this.partName = partName;
        this.partNo = partNo;
        this.partCHG = partCHG;
    }

    public PartPlanResponse() {}

    @Override
    public String toString() {
        return "PartPlanResponse{" +
                "planId=" + planId +
                ", planName='" + planName + '\'' +
                ", planStatus='" + planStatus + '\'' +
                ", partId=" + partId +
                ", partName='" + partName + '\'' +
                ", partNo='" + partNo + '\'' +
                ", partCHG=" + partCHG +
                '}';
    }
}
