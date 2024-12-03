package com.ibnj.acaosocial.repository;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibnj.acaosocial.entity.Schedule;
import com.ibnj.acaosocial.entity.voluntarye;
import com.ibnj.acaosocial.entity.Beneficiaires;

public interface schedulingRepository extends JpaRepository<Schedule, Long> {
    
    List<Schedule> findByDate(LocalDate date);
    
    List<Schedule> findByBeneficiairesandDateBetween(
        Beneficiaires beneficiaires, LocalDate startdate, LocalDate endDate);
    
    List<Schedule> findByfamily_Beneficiaires_IdfamilyandDateBetween(
        String code_family, LocalDate startdate, LocalDate endDate);
            
    List<Schedule> findByvoluntaryeandDateBetween(
        voluntarye voluntarye, LocalDate startdate, LocalDate endDate);
            
}
