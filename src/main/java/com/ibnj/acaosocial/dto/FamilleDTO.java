package com.ibnj.acaosocial.dto;


import java.util.List;


public class FamilleDTO {

    private Long id_famille;
    private String nom_famille;
    private String degre_parente;
    private List<HorairesDTO> horairesDTO;
    private BeneficiairesDTO beneficiairesDTO;

    
    public Long getId_famille() {
        return id_famille;
    }
    public void setId_famille(Long id_famille) {
        this.id_famille = id_famille;
    }
    public String getNom_famille() {
        return nom_famille;
    }
    public void setNom_famille(String nom_famille) {
        this.nom_famille = nom_famille;
    }
    public String getDegre_parente() {
        return degre_parente;
    }
    public void setDegre_parente(String degre_parente) {
        this.degre_parente = degre_parente;
    }
    public List<HorairesDTO> getHorairesDTO() {
        return horairesDTO;
    }
    public void setHorairesDTO(List<HorairesDTO> horairesDTO) {
        this.horairesDTO = horairesDTO;
    }
    public BeneficiairesDTO getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(BeneficiairesDTO beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }


    

    
}
