/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.GainRepository;
import com.school.IbnalHaytham.dao.GroupeRepository;
import com.school.IbnalHaytham.dao.InscriptionRepository;
import com.school.IbnalHaytham.dao.UserRepository;
import com.school.IbnalHaytham.model.AppUser;
import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Groupe;
import com.school.IbnalHaytham.model.Inscription;
import com.school.IbnalHaytham.vo.InscVo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class InscServiceImpl implements InscService {

    @Autowired
    private InscriptionRepository inscRepository;
    @Autowired
    private GroupeRepository groupeRepository;
    @Autowired
    private GainRepository gainRepository;
    @Autowired
    private UserRepository userRepository;

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public List<Inscription> getInscriptions() {
        return inscRepository.findAll();
    }

    @Override
    public String saveInsc(InscVo inscVo) {
        String result;
        AppUser user = userRepository.findById(inscVo.getIdUser()).get();
        Groupe groupe = groupeRepository.findById(inscVo.getIdGroupe()).get();
        Gain gain = gainRepository.findById(inscVo.getIdGain()).get();
        Inscription insc = inscRepository.findByUserAndGroupe(user, groupe, gain);
        if (insc != null) {
            result = "Inscription existe déjà";
        } else {
            try {
                Inscription ins = new Inscription();
                ins.setIdUser(user);
                ins.setIdGroupe(groupe);
                ins.setIdGain(gain);
                ins.setDate(new Date());
                ins.setStatut(inscVo.getStatut());
                inscRepository.save(ins);
                result = "Inscription enregistré avec succès";
            } catch (Exception e) {
                return "Erreur d'enregistrement";
            }
        }
        return result;
    }

    @Override
    public String updateInsc(InscVo inscVo) {
        String result;
        Inscription insc = inscRepository.findById(inscVo.getIdInsc()).get();
        try {
            insc.setStatut(inscVo.getStatut());
            inscRepository.save(insc);
            result="Statut a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeInsc(InscVo inscVo) {
        String result;
         Inscription insc = inscRepository.findById(inscVo.getIdInsc()).get();
        try {
            inscRepository.delete(insc);
            result="Inscription a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }

}
