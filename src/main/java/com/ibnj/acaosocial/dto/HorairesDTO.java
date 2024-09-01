package com.ibnj.acaosocial.dto;

import java.time.LocalDate;


public class HorairesDTO {

    private Long id_horaires;
    private LocalDate date;
    private FamilleDTO familleDTO;
    private BeneficiairesDTO beneficiairesDTO;


    public Long getId_horaires() {
        return id_horaires;
    }
    public void setId_horaires(Long id_horaires) {
        this.id_horaires = id_horaires;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public FamilleDTO getFamilleDTO() {
        return familleDTO;
    }
    public void setFamilleDTO(FamilleDTO familleDTO) {
        this.familleDTO = familleDTO;
    }
    public BeneficiairesDTO getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(BeneficiairesDTO beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }


    

    
}
