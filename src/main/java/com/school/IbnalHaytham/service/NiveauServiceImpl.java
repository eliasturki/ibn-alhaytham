/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.NiveauRepository;
import com.school.IbnalHaytham.model.Niveau;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class NiveauServiceImpl implements NiveauService{

    @Autowired
    private NiveauRepository niveauRepository;
    
    @Override
    public List<Niveau> getNiveau() {
        return niveauRepository.findAll();
    }

    @Override
    public String saveNiveau(Niveau niveau) {
        String result;
        Niveau mod = niveauRepository.findByLibelle(niveau.getLibelle());
        if (mod != null) {
            result="Niveau existe déjà";
        }else{
            try {
                niveauRepository.save(niveau);
                result="Niveau enregistré avec succès";
            } catch (Exception e) {
               return "Erreur d'enregistrement";
            }
        }
        return result;
    }

    @Override
    public String updateNiveau(Niveau niveau) {
         String result;
        try {
            niveauRepository.save(niveau);
            result="Niveau a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeNiveau(Niveau niveau) {
        String result;
        try {
            niveauRepository.delete(niveau);
            result="Niveau a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }
    
}
