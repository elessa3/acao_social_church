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
@Table(name = "famille")
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_famille")
    private Long id_famille;

    @Column(name = "nom_famille")
    private String nom_famille;

    @Column(name = "degre_parente")
    private String degre_parente;

    @ManyToOne
    @JoinColumn(name = "id_beneficiaires", referencedColumnName = "id_beneficiaires")
    private Beneficiaires beneficiaires;

    @OneToMany(mappedBy = "id_famille", cascade = CascadeType.MERGE)
    private List<Horaires> horaires = new ArrayList<>();

    
    //start constructors

    public Famille(){
        
    }

    public Famille(Long id_famille, String nom_famille, String degre_parente) {
        this.id_famille = id_famille;
        this.nom_famille = nom_famille;
        this.degre_parente = degre_parente;
    }
    
    //start getters and setters
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
  
    public List<Horaires> getHoraires() {
        return horaires;
    }

    public void setHoraires(List<Horaires> horaires) {
        this.horaires = horaires;
    }

    //start to string
    @Override
    public String toString() {
        return "Famille [id_famille=" + id_famille + ", nom_famille=" + nom_famille + ", degre_parente=" + degre_parente
                + ", beneficiaires=" + beneficiaires + ", horaires=" + horaires
                + "]";
    }

    
  

    
}
