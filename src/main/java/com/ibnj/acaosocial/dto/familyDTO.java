package com.ibnj.acaosocial.dto;


import java.util.List;


public class familyDTO {

    private Long id_family;
    private String nom_family;
    private String degre_parente;
    private List<schedulingDTO> schedulingDTO;
    private BeneficiairesDTO beneficiairesDTO;

    
    public Long getId_family() {
        return id_family;
    }
    public void setId_family(Long id_family) {
        this.id_family = id_family;
    }
    public String getNom_family() {
        return nom_family;
    }
    public void setNom_family(String nom_family) {
        this.nom_family = nom_family;
    }
    public String getDegre_parente() {
        return degre_parente;
    }
    public void setDegre_parente(String degre_parente) {
        this.degre_parente = degre_parente;
    }
    public List<schedulingDTO> getschedulingDTO() {
        return schedulingDTO;
    }
    public void setschedulingDTO(List<schedulingDTO> schedulingDTO) {
        this.schedulingDTO = schedulingDTO;
    }
    public BeneficiairesDTO getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(BeneficiairesDTO beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }


    

    
}
