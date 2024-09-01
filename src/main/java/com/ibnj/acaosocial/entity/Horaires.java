package com.ibnj.acaosocial.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "horaires")
public class Horaires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horaires")
    private Long id_horaires;
    
    @Column(name = "date")
    private LocalDate date;

    @ManyToMany
    @Column(name = "famille")
    private Famille famille;

    @ManyToMany
    private Beneficiaires beneficiaires;

    @ManyToOne
    @JoinColumn(name = "id_volontaire", referencedColumnName = "id_volontaire")
    private Volontaire volontaire;
    
    //inicio construtores
    public Horaires(){
        
    }
    
    public Horaires(Long id_horaires, LocalDate date, Famille famille) {
        this.id_horaires = id_horaires;
        this.date = date;
        this.famille = famille;
    }

    //start getters and setters
    public Long getId_horaires() {
        return id_horaires;
    }

    public void setId_horaires(Long id_horaires) {
        this.id_horaires = id_horaires;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Beneficiaires getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(Beneficiaires beneficiaires) {
        this.beneficiaires = beneficiaires;
    }

    public Volontaire getVolontaire() {
        return volontaire;
    }

    public void setVolontaire(Volontaire volontaire) {
        this.volontaire = volontaire;
    }


    //start Tostring
    @Override
    public String toString() {
        return "Horaires [id_horaires=" + id_horaires + ", date=" + date + ", famille=" + famille + ", beneficiaires="
                + beneficiaires + ", volontaire=" + volontaire + "]";
    }

    
    

    

    
}
