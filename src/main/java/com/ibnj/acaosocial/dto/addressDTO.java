package com.ibnj.acaosocial.dto;

import java.util.List;


public class addressDTO {    
    
    private Long id_address;
    private String rue_avenue;
    private Long nombre;
    private String complement;
    private String commune;
    private Long code_postal;
    private List<BeneficiairesDTO> beneficiairesDTO;


    public Long getId_address() {
        return id_address;
    }
    public void setId_address(Long id_address) {
        this.id_address = id_address;
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
    public List<BeneficiairesDTO> getBeneficiairesDTO() {
        return beneficiairesDTO;
    }
    public void setBeneficiairesDTO(List<BeneficiairesDTO> beneficiairesDTO) {
        this.beneficiairesDTO = beneficiairesDTO;
    }

    
    

}
