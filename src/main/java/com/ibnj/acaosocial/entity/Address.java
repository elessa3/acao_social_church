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
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address")
    private Long id_address;

    @Column(name = "street")
    private String street;

    @Column(name = "name")
    private Long name;

    @Column(name = "complement")
    private String complement;

    @Column(name = "commune")
    private String commune;

    @Column(name = "code_postal")
    private Long code_postal;


    @OneToMany(mappedBy = "beneficiaires")
    private List<Beneficiaires> beneficiaires = new ArrayList<>();


    //start constructors

    public Address(){

    }
    
    public Address(Long id_address, String street, Long name, String complement, String commune, Long code_postal) {
        this.id_address = id_address;
        this.street = street;
        this.name = name;
        this.complement = complement;
        this.commune = commune;
        this.code_postal = code_postal;
    }

    //start getters and setters
    public Long getId_address() {
        return id_address;
    }
    public void setId_address(Long id_address) {
        this.id_address = id_address;
    }
    public String getstreet() {
        return street;
    }
    public void setstreet(String street) {
        this.street = street;
    }
    public Long getname() {
        return name;
    }
    public void setname(Long name) {
        this.name = name;
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
        return "address [id_address=" + id_address + ", street=" + street + ", name=" + name
                + ", complement=" + complement + ", commune=" + commune + ", code_postal=" + code_postal
                + ", beneficiaires=" + beneficiaires + "]";
    }



   


        
    
}
