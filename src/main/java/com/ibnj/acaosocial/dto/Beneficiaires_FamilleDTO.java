package com.ibnj.acaosocial.dto;

import java.util.List;

public class Beneficiaires_FamilleDTO {
    
    private Long id_famille;
    private String nom_famille;
    private String degre_parente;
    private String code_famille;
    private List<BeneficiairesDTO> beneficiairesDTO;

    //classe criada para obter os dados da familia e beneficiarios pelo codigo de familia
    
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
    public String getCode_famille() {
        return code_famille;
    }
    public void setCode_famille(String code_famille) {
        this.code_famille = code_famille;
    }
    public List<BeneficiairesDTO> getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(List<BeneficiairesDTO> beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }

    
    
}
