package com.ibnj.acaosocial.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibnj.acaosocial.entity.Horaires;
import com.ibnj.acaosocial.exception.DuplicateException;
import com.ibnj.acaosocial.repository.HorairesRepository;

@Service
public class HorairesService {

    @Autowired
    private HorairesRepository horairesRepository;

    //Lista todos os beneficiarios
    public List<Horaires> getAllHoraires(){
        return horairesRepository.findAll();
    }

    //Lista pelo id
    public Horaires getHorairesById(Long id){
        return horairesRepository.findById(id).get();
    }

    //Salva novo beneficiario
    public Horaires saveHoraires(Horaires horaires){
        LocalDate startOfMonth = horaires.getDate().withDayOfMonth(1);
        LocalDate endOfMonth = horaires.getDate().withDayOfMonth(
            horaires.getDate().lengthOfMonth());

        //Verifica se o beneficiario ja tem um agendamento
        List<Horaires> horaires_beneficiaires = horairesRepository.findByBeneficiairesandDateBetween(
            horaires.getBeneficiaires(), startOfMonth, endOfMonth);
        if (!horaires_beneficiaires.isEmpty()) {
            throw new DuplicateException("Beneficiario ja possui agendamento neste mês");
        }

        //Verifica se a familia ja tem um agendamento no mes
        List<Horaires> horaires_famille = horairesRepository.findByFamille_Beneficiaires_IdFamilleandDateBetween(
            horaires.getFamille().getBeneficiaires().getCode_famille(), startOfMonth, endOfMonth);
            
        if (!horaires_famille.isEmpty()) {
            throw new DuplicateException("Familia ja possui agendamento neste mês");
        }


        return horairesRepository.save(horaires);
    }

    //Atualiza os dados do beneficiario
    public Horaires updateHoraires(Horaires horaires,  Long id){
        Horaires horairesEnregistre = getHorairesById(id);

        horairesEnregistre.setDate(horaires.getDate());
        horairesEnregistre.setFamille(horaires.getFamille());
        horairesEnregistre.setVolontaire(horaires.getVolontaire());
        

        return horairesRepository.save(horairesEnregistre);

    }

    //Deleta os dados
    public Horaires deleteHoraires(Long id){
        horairesRepository.deleteById(id);
        return getHorairesById(id);
    }
    
}
