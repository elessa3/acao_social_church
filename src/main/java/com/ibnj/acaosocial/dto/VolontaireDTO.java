package com.ibnj.acaosocial.dto;

import java.util.Set;

public class VolontaireDTO {

    private Long id_volontaire;
    private String nom;
    private String prenom;
    private Long telephone;
    private Set<HorairesDTO> horairesDTO;


    public Long getId_volontaire() {
        return id_volontaire;
    }
    public void setId_volontaire(Long id_volontaire) {
        this.id_volontaire = id_volontaire;
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
    public Set<HorairesDTO> getHorairesDTO() {
        return horairesDTO;
    }
    public void setHorairesDTO(Set<HorairesDTO> horairesDTO) {
        this.horairesDTO = horairesDTO;
    }


    
    
}
