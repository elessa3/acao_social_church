package com.ibnj.acaosocial.dto;

import java.util.List;

public class Famille_AdresseDTO {

    private Long id_adresse;
    private String nom_famille;
    private Long code_famille;
    private List<Beneficiaires_FamilleDTO> beneficiaires_FamilleDTO;

    //classe criada para obter o endereco e o codigo de familia

    
    public Long getId_adresse() {
        return id_adresse;
    }
    public void setId_adresse(Long id_adresse) {
        this.id_adresse = id_adresse;
    }
    public String getNom_famille() {
        return nom_famille;
    }
    public void setNom_famille(String nom_famille) {
        this.nom_famille = nom_famille;
    }
    public Long getCode_famille() {
        return code_famille;
    }
    public void setCode_famille(Long code_famille) {
        this.code_famille = code_famille;
    }
    public List<Beneficiaires_FamilleDTO> getBeneficiaires_FamilleDTO() {
        return beneficiaires_FamilleDTO;
    }
    public void setBeneficiaires_FamilleDTO(List<Beneficiaires_FamilleDTO> beneficiaires_FamilleDTO) {
        this.beneficiaires_FamilleDTO = beneficiaires_FamilleDTO;
    }


    
    
    
}
