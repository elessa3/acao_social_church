package com.ibnj.acaosocial.dto;

import java.util.Set;

public class voluntaryeDTO {

    private Long id_voluntarye;
    private String nom;
    private String prenom;
    private Long telephone;
    private Set<schedulingDTO> schedulingDTO;


    public Long getId_voluntarye() {
        return id_voluntarye;
    }
    public void setId_voluntarye(Long id_voluntarye) {
        this.id_voluntarye = id_voluntarye;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Long getTelephone() {
        return telephone;
    }
    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
    public Set<schedulingDTO> getschedulingDTO() {
        return schedulingDTO;
    }
    public void setschedulingDTO(Set<schedulingDTO> schedulingDTO) {
        this.schedulingDTO = schedulingDTO;
    }


    
    
}
