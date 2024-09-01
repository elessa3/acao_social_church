package com.ibnj.acaosocial.repository;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibnj.acaosocial.entity.Horaires;
import com.ibnj.acaosocial.entity.Volontaire;
import com.ibnj.acaosocial.entity.Beneficiaires;

public interface HorairesRepository extends JpaRepository<Horaires, Long> {
    
    List<Horaires> findByDate(LocalDate date);
    
    List<Horaires> findByBeneficiairesandDateBetween(
        Beneficiaires beneficiaires, LocalDate startdate, LocalDate endDate);
    
    List<Horaires> findByFamille_Beneficiaires_IdFamilleandDateBetween(
        String code_famille, LocalDate startdate, LocalDate endDate);
            
    List<Horaires> findByVolontaireandDateBetween(
        Volontaire volontaire, LocalDate startdate, LocalDate endDate);
            
}
