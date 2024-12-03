package com.ibnj.acaosocial.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;


public class BeneficiairesDTO {
    
    private Long id_beneficiaires;
    private String nom;
    private String prenom;
    private LocalDate date_de_naissance;
    private Long telephone;
    private String mail;
    private String code_family;
    private List<familyDTO> familyDTO;
    private Set<addressDTO> adressseDTO;

    
    public Long getId_beneficiaires() {
        return id_beneficiaires;
    }
    public void setId_beneficiaires(Long id_beneficiaires) {
        this.id_beneficiaires = id_beneficiaires;
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
    public LocalDate getDate_de_naissance() {
        return date_de_naissance;
    }
    public void setDate_de_naissance(LocalDate date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }
    public Long getTelephone() {
        return telephone;
    }
    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getCode_family() {
        return code_family;
    }
    public void setCode_family(String code_family) {
        this.code_family = code_family;
    }
    public List<familyDTO> getfamilyDTO() {
        return familyDTO;
    }
    public void setfamilyDTO(List<familyDTO> familyDTO) {
        this.familyDTO = familyDTO;
    }
    public Set<addressDTO> getAdressseDTO() {
        return adressseDTO;
    }
    public void setAdressseDTO(Set<addressDTO> adressseDTO) {
        this.adressseDTO = adressseDTO;
    }


   


}
