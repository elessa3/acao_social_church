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
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_schedule")
    private Long id_schedule;
    
    @Column(name = "date")
    private LocalDate date;

    @ManyToMany
    @Column(name = "family")
    private Family family;

    @ManyToMany
    private Beneficiaires beneficiaires;

    @ManyToOne
    @JoinColumn(name = "id_voluntary", referencedColumnName = "id_voluntary")
    private Voluntary voluntary;
    
    //inicio construtores
    public Schedule(){
        
    }
    
    public Schedule(Long id_scheduling, LocalDate date, Family family) {
        this.id_schedule = id_schedule;
        this.date = date;
        this.family = family;
    }

    //start getters and setters
    public Long getId_schedule() {
        return id_schedule;
    }

    public void setId_schedule(Long id_schedule) {
        this.id_schedule = id_schedule;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Beneficiaires getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(Beneficiaires beneficiaires) {
        this.beneficiaires = beneficiaires;
    }

    public Voluntary getVoluntary() {
        return voluntary;
    }

    public void setVoluntary(Voluntary voluntary) {
        this.voluntary = voluntary;
    }


    //start Tostring
    @Override
    public String toString() {
        return "schedule [id_schedule=" + id_schedule + ", date=" + date + ", family=" + family + ", beneficiaires="
                + beneficiaires + ", voluntary=" + voluntary + "]";
    }

    
    

    

    
}
