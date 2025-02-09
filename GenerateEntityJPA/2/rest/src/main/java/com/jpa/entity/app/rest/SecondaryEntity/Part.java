package com.jpa.entity.app.rest.SecondaryEntity;

import javax.persistence.*;

@Entity
@Table(name = "parts")
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long partId;

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

    public Part(Long partId, String partName, String partNo, Double partCHG) {
        this.partId = partId;
        this.partName = partName;
        this.partNo = partNo;
        this.partCHG = partCHG;
    }

    private String partName;
    private String partNo;
    private Double partCHG;

    public Part() {}


}
