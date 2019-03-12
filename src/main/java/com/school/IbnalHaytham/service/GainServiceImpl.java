/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.GainRepository;
import com.school.IbnalHaytham.dao.ModuleRepository;
import com.school.IbnalHaytham.dao.NiveauRepository;
import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.model.Niveau;
import com.school.IbnalHaytham.vo.GainVo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class GainServiceImpl implements GainService{

    @Autowired
    private ModuleRepository moduleRepository;
    @Autowired
    private NiveauRepository niveauRepository;
    @Autowired
    private GainRepository gainRepository;
    
    @Override
    public String saveGain(GainVo gainVo) {
        String result;
        Optional<Module> mod = moduleRepository.findById(gainVo.getIdModule());
        Optional<Niveau> niv= niveauRepository.findById(gainVo.getIdNiveau());
        Gain gain= gainRepository.findByModuleAndNiveau(mod.get(),niv.get());
        if (gain != null) {
            result="Gain existe déjà";
        }else{
            try {
                Gain g= new Gain(niv.get(), mod.get(), gainVo.getPrix());
                gainRepository.save(g);
                result="Gain enregistré avec succès";
            } catch (Exception e) {
               return "Erreur d'enregistrement";
            }
        }
        return result;
    }

    @Override
    public String updateGain(GainVo gainVo) {
        String result;
        Optional<Gain> gainO= gainRepository.findById(gainVo.getIdGain());
        Gain gain=gainO.get();
        try {
            gain.setPrix(gainVo.getPrix());
            gainRepository.save(gain);
            result="Prix a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeGain(GainVo gainVo) {
        String result;
         Optional<Gain> gainO= gainRepository.findById(gainVo.getIdGain());
         Gain gain=gainO.get();
        try {
            gainRepository.delete(gain);
            result="Gain a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }

    @Override
    public List<Module> searchModuleByLevel(Integer idNiveau) {
        List<Module> modules = new ArrayList<>();
        Optional<Niveau> niveau=niveauRepository.findById(idNiveau);
        List<Gain> gains=gainRepository.findByLevel(niveau.get());
        gains.forEach((t) -> {
            modules.add(t.getIdModule());
        });
        return modules;
    }

    @Override
    public List<Gain> getGains() {
        return gainRepository.findAll();
    }
    
}
