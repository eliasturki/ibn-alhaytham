/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.GroupeRepository;
import com.school.IbnalHaytham.model.Groupe;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class GroupeServiceImpl implements GroupeService{

    @Autowired
    private GroupeRepository groupeRepository;
    
    @Override
    public List<Groupe> getGroupes() {
        return groupeRepository.findAll();
    }

    @Override
    public String saveGroupe(Groupe groupe) {
        String result;
        Groupe grp = groupeRepository.findByLibelle(groupe.getLibelle());
        if (grp != null) {
            result="Groupe existe déjà";
        }else{
            try {
                groupeRepository.save(groupe);
                result="Groupe enregistré avec succès";
            } catch (Exception e) {
               return "Erreur d'enregistrement";
            }
        }
        return result;
    }

    @Override
    public String updateGroupe(Groupe groupe) {
        String result;
        try {
            groupeRepository.save(groupe);
            result="Groupe a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeGroupe(Groupe groupe) {
        String result;
        try {
            groupeRepository.delete(groupe);
            result="Groupe a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }
    
}
