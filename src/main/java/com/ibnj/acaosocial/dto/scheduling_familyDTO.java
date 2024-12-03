package com.ibnj.acaosocial.dto;

import java.time.LocalDate;
import java.util.List;

public class scheduling_familyDTO {

    private Long id_family;
    private String nom_family;
    private LocalDate date;
    private List<Beneficiaires_familyDTO> Beneficiaires_familyDTO;

    //classe criada para obter as informacoes de data e familia

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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public List<Beneficiaires_familyDTO> getBeneficiaires_familyDTO() {
        return Beneficiaires_familyDTO;
    }
    public void setBeneficiaires_familyDTO(List<Beneficiaires_familyDTO> beneficiaires_familyDTO) {
        Beneficiaires_familyDTO = beneficiaires_familyDTO;
    }

    
}