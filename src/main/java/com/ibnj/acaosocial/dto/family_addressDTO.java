package com.ibnj.acaosocial.dto;

import java.util.List;

public class family_addressDTO {

    private Long id_address;
    private String nom_family;
    private Long code_family;
    private List<Beneficiaires_familyDTO> beneficiaires_familyDTO;

    //classe criada para obter o endereco e o codigo de familia

    
    public Long getId_address() {
        return id_address;
    }
    public void setId_address(Long id_address) {
        this.id_address = id_address;
    }
    public String getNom_family() {
        return nom_family;
    }
    public void setNom_family(String nom_family) {
        this.nom_family = nom_family;
    }
    public Long getCode_family() {
        return code_family;
    }
    public void setCode_family(Long code_family) {
        this.code_family = code_family;
    }
    public List<Beneficiaires_familyDTO> getBeneficiaires_familyDTO() {
        return beneficiaires_familyDTO;
    }
    public void setBeneficiaires_familyDTO(List<Beneficiaires_familyDTO> beneficiaires_familyDTO) {
        this.beneficiaires_familyDTO = beneficiaires_familyDTO;
    }


    
    
    
}
