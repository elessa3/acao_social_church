package com.ibnj.acaosocial.repository;

import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ibnj.acaosocial.entity.Schedule;
import com.ibnj.acaosocial.entity.Voluntary;
import com.ibnj.acaosocial.entity.Beneficiaires;

public interface SchedulingRepository extends JpaRepository<Schedule, Long> {
    
    List<Schedule> findByDate(LocalDate date);
    
    List<Schedule> findByBeneficiairesandDateBetween(
        Beneficiaires beneficiaires, LocalDate startdate, LocalDate endDate);
    
    List<Schedule> findByFamily_Beneficiaires_IdfamilyandDateBetween(
        String code_family, LocalDate startdate, LocalDate endDate);
            
    List<Schedule> findByVoluntaryandDateBetween(
        Voluntary voluntary, LocalDate startdate, LocalDate endDate);
            
}
