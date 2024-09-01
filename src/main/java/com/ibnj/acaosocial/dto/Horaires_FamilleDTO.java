package com.ibnj.acaosocial.dto;

import java.time.LocalDate;
import java.util.List;

public class Horaires_FamilleDTO {

    private Long id_famille;
    private String nom_famille;
    private LocalDate date;
    private List<Beneficiaires_FamilleDTO> Beneficiaires_FamilleDTO;

    //classe criada para obter as informacoes de data e familia

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
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public List<Beneficiaires_FamilleDTO> getBeneficiaires_FamilleDTO() {
        return Beneficiaires_FamilleDTO;
    }
    public void setBeneficiaires_FamilleDTO(List<Beneficiaires_FamilleDTO> beneficiaires_FamilleDTO) {
        Beneficiaires_FamilleDTO = beneficiaires_FamilleDTO;
    }

    
}