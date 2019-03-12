/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.SalleRepository;
import com.school.IbnalHaytham.model.Salle;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class SalleServiceImpl implements SalleService{
    
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public List<Salle> getSalles() {
        return salleRepository.findAll();
    }

    @Override
    public String saveSalle(Salle salle) {
        String result;
        Salle sal = salleRepository.findByLibelle(salle.getLibelle());
        if (sal != null) {
            result="Salle existe déjà";
        }else{
            try {
                salleRepository.save(salle);
                result="Salle enregistré avec succès";
            } catch (Exception e) {
               return "Erreur d'enregistrement";
            }
        }
        return result;
    }

    @Override
    public String updateSalle(Salle salle) {
        String result;
        try {
            salleRepository.save(salle);
            result="Salle a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeSalle(Salle salle) {
        String result;
        try {
            salleRepository.delete(salle);
            result="Salle a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }
    
}
