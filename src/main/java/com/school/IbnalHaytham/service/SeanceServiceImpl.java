/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.GroupeRepository;
import com.school.IbnalHaytham.dao.SalleRepository;
import com.school.IbnalHaytham.dao.SeanceRepository;
import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Groupe;
import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.model.Niveau;
import com.school.IbnalHaytham.model.Salle;
import com.school.IbnalHaytham.model.Seance;
import com.school.IbnalHaytham.vo.SeanceVo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author abbasturki.elias
 */
@Service
public class SeanceServiceImpl implements SeanceService {

    @Autowired
    private SeanceRepository seanceRepository;
    @Autowired
    private GroupeRepository groupeRepository;
    @Autowired
    private SalleRepository salleRepository;

    @Override
    public List<Seance> getSeances() {
        return seanceRepository.findAll();
    }

    @Override
    public String saveSeance(SeanceVo seanceVo) {
        String result;
        Groupe grp = groupeRepository.findById(seanceVo.getIdGroupe()).get();
        Salle sal = salleRepository.findById(seanceVo.getIdSalle()).get();
        try {
            Seance seance = seanceRepository.findByGroupeAndSeance(seanceVo.getJour(), seanceVo.getHeurDebut(), seanceVo.getHeurFin(), grp);
            if (seance != null) {
                result = "Seance existe déjà";
            } else {
                try {
                    Seance s = new Seance();
                    s.setJour(seanceVo.getJour());
                    s.setHeurDebut(seanceVo.getHeurDebut());
                    s.setHeurFin(seanceVo.getHeurFin());
                    s.setIdGroupe(grp);
                    s.setIdSalle(sal);
                    seanceRepository.save(s);
                    result = "Seance enregistré avec succès";
                } catch (Exception e) {
                    return "Erreur d'enregistrement";
                }
            }
        } catch (Exception e) {
            return "Seance existe déjà";
        }

        return result;
    }

    @Override
    public String updateSeance(SeanceVo seanceVo) {
        String result;
        Seance seance = seanceRepository.findById(seanceVo.getIdSeance()).get();
        try {
            seance.setJour(seanceVo.getJour());
            seance.setHeurDebut(seanceVo.getHeurDebut());
            seance.setHeurFin(seanceVo.getHeurFin());
            seanceRepository.save(seance);
            result = "Seance a été modifié avec succès";
        } catch (Exception e) {
            return "Erreur de modification";
        }
        return result;
    }

    @Override
    public String removeSeance(SeanceVo seanceVo) {
        String result;
        Seance seance = seanceRepository.findById(seanceVo.getIdSeance()).get();
        try {
            seanceRepository.delete(seance);
            result="Seance a été supprimé avec succès";
        } catch (Exception e) {
            return "Erreur de suppression";
        }
        return result;
    }

}
