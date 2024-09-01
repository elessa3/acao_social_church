package com.ibnj.acaosocial.entity;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "volontaire")
public class Volontaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_volontaire")
    private Long id_volontaire;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private Long telephone;

    @OneToMany(mappedBy = "horaires")
    private Set<Horaires> horaires;

    
    //start constructor

    public Volontaire(){

    }
    

    public Volontaire(Long id_volontaire, String nom, String prenom, Long telephone) {
        this.id_volontaire = id_volontaire;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    //start getters and setters
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
    
    public Set<Horaires> getHoraires() {
        return horaires;
    }

    public void setHoraires(Set<Horaires> horaires) {
        this.horaires = horaires;
    }

    @Override
    public String toString() {
        return "Volontaire [id_volontaire=" + id_volontaire + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
                + telephone + "]";
    }


   

    
    
}
