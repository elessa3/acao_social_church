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
@Table(name = "voluntary")
public class Voluntary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voluntary")
    private Long id_voluntary;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "telephone")
    private Long telephone;

    @OneToMany(mappedBy = "scheduling")
    private Set<Schedule> scheduling;

    
    //start constructor

    public Voluntary(){

    }
    

    public Voluntary(Long id_voluntary, String nom, String prenom, Long telephone) {
        this.id_voluntary = id_voluntary;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }

    //start getters and setters
    public Long getId_voluntary() {
        return id_voluntary;
    }
    public void setId_voluntary(Long id_voluntary) {
        this.id_voluntary = id_voluntary;
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
    
    public Set<Schedule> getscheduling() {
        return scheduling;
    }

    public void setscheduling(Set<Schedule> scheduling) {
        this.scheduling = scheduling;
    }

    @Override
    public String toString() {
        return "voluntary [id_voluntary=" + id_voluntary + ", nom=" + nom + ", prenom=" + prenom + ", telephone="
                + telephone + "]";
    }


   

    
    
}
