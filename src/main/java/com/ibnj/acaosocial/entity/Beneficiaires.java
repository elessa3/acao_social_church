package com.ibnj.acaosocial.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "beneficiaires")
public class Beneficiaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_beneficiaires")
    private Long id_beneficiaires;

    //@NotBlanc("campo obrigatorio")
    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_de_naissance")
    private LocalDate date_de_naissance;

    @Column(name = "telephone")
    private Long telephone;

    @Column(name = "mail")
    private String mail;
    
    @Column(name = "code_family")
    private String code_family;
  
    @OneToMany(mappedBy = "beneficiaires")
    private List<Family> familier = new ArrayList<>();

    @OneToMany(mappedBy = "address")
    private Set<Address> address;

     

    //Start construtors
    
    public Beneficiaires() {
    }


    public Beneficiaires(Long id_beneficiaires, String nom, String prenom, LocalDate date_de_naissance, Long telephone,
            String mail, String code_family) {
        this.id_beneficiaires = id_beneficiaires;
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.telephone = telephone;
        this.mail = mail;        
        this.code_family = code_family;
    }   


    //Start getters and setters

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

    public Set<Address> getAddress() {
        return address;
    }

    public void setaddress(Set<Address> address) {
        this.address = address;
    }

    public List<Family> getFamilier() {
        return familier;
    }

    public void setFamilier(List<Family> familier) {
        this.familier = familier;
    }

    
    //Start toString
    @Override
    public String toString() {
        return "Beneficiaires [id_beneficiaires=" + id_beneficiaires + ", nom=" + nom + ", prenom=" + prenom
                + ", date_de_naissance=" + date_de_naissance + ", telephone=" + telephone + ", mail=" + mail
                + ", code_family=" + code_family + ", familier=" + familier + ", address=" + address + "]";
    }



    

    
    
    
    

}