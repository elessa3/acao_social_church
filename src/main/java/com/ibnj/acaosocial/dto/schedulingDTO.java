package com.ibnj.acaosocial.dto;

import java.time.LocalDate;


public class schedulingDTO {

    private Long id_scheduling;
    private LocalDate date;
    private familyDTO familyDTO;
    private BeneficiairesDTO beneficiairesDTO;


    public Long getId_scheduling() {
        return id_scheduling;
    }
    public void setId_scheduling(Long id_scheduling) {
        this.id_scheduling = id_scheduling;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public familyDTO getfamilyDTO() {
        return familyDTO;
    }
    public void setfamilyDTO(familyDTO familyDTO) {
        this.familyDTO = familyDTO;
    }
    public BeneficiairesDTO getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(BeneficiairesDTO beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }


    

    
}
