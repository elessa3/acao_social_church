package com.ibnj.acaosocial.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "adresse")
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adresse")
    private Long id_adresse;

    @Column(name = "rue_avenue")
    private String rue_avenue;

    @Column(name = "nombre")
    private Long nombre;

    @Column(name = "complement")
    private String complement;

    @Column(name = "commune")
    private String commune;

    @Column(name = "code_postal")
    private Long code_postal;


    @OneToMany(mappedBy = "beneficiaires")
    private List<Beneficiaires> beneficiaires = new ArrayList<>();


    //start constructors

    public Adresse(){

    }
    
    public Adresse(Long id_adresse, String rue_avenue, Long nombre, String complement, String commune, Long code_postal) {
        this.id_adresse = id_adresse;
        this.rue_avenue = rue_avenue;
        this.nombre = nombre;
        this.complement = complement;
        this.commune = commune;
        this.code_postal = code_postal;
    }

    //start getters and setters
    public Long getId_adresse() {
        return id_adresse;
    }
    public void setId_adresse(Long id_adresse) {
        this.id_adresse = id_adresse;
    }
    public String getRue_avenue() {
        return rue_avenue;
    }
    public void setRue_avenue(String rue_avenue) {
        this.rue_avenue = rue_avenue;
    }
    public Long getNombre() {
        return nombre;
    }
    public void setNombre(Long nombre) {
        this.nombre = nombre;
    }
    public String getComplement() {
        return complement;
    }
    public void setComplement(String complement) {
        this.complement = complement;
    }
    public String getCommune() {
        return commune;
    }
    public void setCommune(String commune) {
        this.commune = commune;
    }
    public Long getCode_postal() {
        return code_postal;
    }
    public void setCode_postal(Long code_postal) {
        this.code_postal = code_postal;
    }

    //start Tostring
    @Override
    public String toString() {
        return "Adresse [id_adresse=" + id_adresse + ", rue_avenue=" + rue_avenue + ", nombre=" + nombre
                + ", complement=" + complement + ", commune=" + commune + ", code_postal=" + code_postal
                + ", beneficiaires=" + beneficiaires + "]";
    }



   


        
    
}
