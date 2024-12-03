package com.ibnj.acaosocial.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Schedule;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.schedulingRepository;

@Service
public class schedulingService {

    @Autowired
    private schedulingRepository schedulingRepository;

    //Lista todos os scheduling
    public List<Schedule> getAllscheduling(){
        return schedulingRepository.findAll();
    }

    //Lista pelo id
    public Schedule getschedulingById(Long id){
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
    public Schedule savescheduling(Schedule scheduling){
        LocalDate startOfMonth = scheduling.getDate().withDayOfMonth(1);
        LocalDate endOfMonth = scheduling.getDate().withDayOfMonth(
            scheduling.getDate().lengthOfMonth());

        //Verifica se o beneficiario ja tem um agendamento
        List<Schedule> scheduling_beneficiaires = schedulingRepository.findByBeneficiairesandDateBetween(
            scheduling.getBeneficiaires(), startOfMonth, endOfMonth);
        if (!scheduling_beneficiaires.isEmpty()) {
            throw new DuplicateException("Beneficiario ja possui agendamento neste mês");
        }

        //Verifica se a familia ja tem um agendamento no mes
        List<Schedule> scheduling_family = schedulingRepository.findByfamily_Beneficiaires_IdfamilyandDateBetween(
            scheduling.getfamily().getBeneficiaires().getCode_family(), startOfMonth, endOfMonth);
            
        if (!scheduling_family.isEmpty()) {
            throw new DuplicateException("Familia ja possui agendamento neste mês");
        }


        return schedulingRepository.save(scheduling);
    }

    //Atualiza os dados do beneficiario
    public Schedule updatescheduling(Schedule scheduling,  Long id){
        Schedule schedulingEnregistre = getschedulingById(id);

        schedulingEnregistre.setDate(scheduling.getDate());
        schedulingEnregistre.setfamily(scheduling.getfamily());
        schedulingEnregistre.setvoluntarye(scheduling.getvoluntarye());
        

        return schedulingRepository.save(schedulingEnregistre);

    }

    //Deleta os dados
    public Schedule deletescheduling(Long id){
        schedulingRepository.deleteById(id);
        return getschedulingById(id);
    }
    
}
