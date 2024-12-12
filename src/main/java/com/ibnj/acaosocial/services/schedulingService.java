package com.ibnj.acaosocial.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Schedule;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.SchedulingRepository;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository schedulingRepository;

    //Lista todos os scheduling
    public List<Schedule> getAllScheduling(){
        return schedulingRepository.findAll();
    }

    //Lista pelo id
    public Schedule getSchedulingById(Long id){
        return schedulingRepository.findById(id).get();
    }
    // pelos voluntarios
   /* public scheduling getschedulingByvoluntaryes(LocalDate date){
        LocalDate startOfMonth = scheduling.getDate().withDayOfMonth(1);
        LocalDate endOfMonth = scheduling.getDate().withDayOfMonth(
            scheduling.getDate().lengthOfMonth());

        return schedulingRepository.findByvoluntaryeandDateBetween(scheduling.getvoluntarye() , startdate, endDate);
    }*/

    //Salva novo beneficiario
    public Schedule saveScheduling(Schedule scheduling){
        LocalDate startOfMonth = scheduling.getDate().withDayOfMonth(1);
        LocalDate endOfMonth = scheduling.getDate().withDayOfMonth(
            scheduling.getDate().lengthOfMonth());

        //Verifica se o beneficiario ja tem um agendamento
        List<Schedule> scheduling_beneficiaires = schedulingRepository.findByBeneficiairesandDateBetween(
            scheduling.getBeneficiaires(), startOfMonth, endOfMonth);
        if (!scheduling_beneficiaires.isEmpty()) {
            throw new DuplicateException("Beneficiary already registered this month");
        }

        //Verifica se a familia ja tem um agendamento no mes
        List<Schedule> scheduling_family = schedulingRepository.findByFamily_Beneficiaires_IdfamilyandDateBetween (
            scheduling.getFamily().getBeneficiaires().getCode_family(), startOfMonth, endOfMonth);
            
        if (!scheduling_family.isEmpty()) {
            throw new DuplicateException("Family already registered this month");
        }


        return schedulingRepository.save(scheduling);
    }

    //Atualiza os dados do beneficiario
    public Schedule updateScheduling(Schedule scheduling,  Long id){
        Schedule schedulingEnregistry = getSchedulingById(id);

        schedulingEnregistry.setDate(scheduling.getDate());
        schedulingEnregistry.setFamily(scheduling.getFamily());
        schedulingEnregistry.setVoluntary(scheduling.getVoluntary());
        

        return schedulingRepository.save(schedulingEnregistry);

    }

    //Deleta os dados
    public Schedule deleteScheduling(Long id){
        schedulingRepository.deleteById(id);
        return getSchedulingById(id);
    }
    
}
