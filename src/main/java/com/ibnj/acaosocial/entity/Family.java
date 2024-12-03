package com.ibnj.acaosocial.entity;

import java.util.List;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_family")
    private Long id_family;

    @Column(name = "nom_family")
    private String nom_family;

    @Column(name = "degre_parente")
    private String degre_parente;

    @ManyToOne
    @JoinColumn(name = "id_beneficiaires", referencedColumnName = "id_beneficiaires")
    private Beneficiaires beneficiaires;

    @OneToMany(mappedBy = "id_family", cascade = CascadeType.MERGE)
    private List<Schedule> scheduling = new ArrayList<>();

    
    //start constructors

    public Family(){
        
    }

    public Family(Long id_family, String nom_family, String degre_parente) {
        this.id_family = id_family;
        this.nom_family = nom_family;
        this.degre_parente = degre_parente;
    }
    
    //start getters and setters
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
    
    public String getDegre_parente() {
        return degre_parente;
    }
    public void setDegre_parente(String degre_parente) {
        this.degre_parente = degre_parente;
    }

    public Beneficiaires getBeneficiaires() {
        return beneficiaires;
    }
    public void setBeneficiaires(Beneficiaires beneficiaires) {
        this.beneficiaires = beneficiaires;
    }    
  
    public List<Schedule> getscheduling() {
        return scheduling;
    }

    public void setscheduling(List<Schedule> scheduling) {
        this.scheduling = scheduling;
    }

    //start to string
    @Override
    public String toString() {
        return "family [id_family=" + id_family + ", nom_family=" + nom_family + ", degre_parente=" + degre_parente
                + ", beneficiaires=" + beneficiaires + ", scheduling=" + scheduling
                + "]";
    }

    
  

    
}
