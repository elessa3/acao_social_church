package com.ibnj.acaosocial.dto;

import java.util.List;

public class Beneficiaires_familyDTO {
    
    private Long id_family;
    private String nom_family;
    private String degre_parente;
    private String code_family;
    private List<BeneficiairesDTO> beneficiairesDTO;

    //classe criada para obter os dados da familia e beneficiarios pelo codigo de familia
    
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
    public String getCode_family() {
        return code_family;
    }
    public void setCode_family(String code_family) {
        this.code_family = code_family;
    }
    public List<BeneficiairesDTO> getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(List<BeneficiairesDTO> beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }

    
    
}
