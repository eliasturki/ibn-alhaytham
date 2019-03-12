/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.ModuleRepository;
import com.school.IbnalHaytham.model.Module;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class ModuleServiceImpl implements ModuleService{
    
    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public String saveModule(Module module) {
        String result;
        Module mod = moduleRepository.findByLibelle(module.getLibelle());
        if (mod != null) {
            result="Module existe déjà";
        }else{
            try {
                moduleRepository.save(module);
                result="Module enregistré avec succès";
            } catch (Exception e) {
               return "Erreur d'enregistrement";
            }
        }
        return result;
    }

    @Override
    public String updateModule(Module module) {
        String result;
        try {
            moduleRepository.save(module);
            result="Module a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeModule(Module module) {
        String result;
        try {
            moduleRepository.delete(module);
            result="Module a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }

    @Override
    public List<Module> getModules() {
       return moduleRepository.findAll();
    }
    
}
