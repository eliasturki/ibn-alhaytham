/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Niveau;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface NiveauService {
    
    public List<Niveau> getNiveau();
    public String saveNiveau(Niveau niveau);
    public String updateNiveau(Niveau niveau);
    public String removeNiveau(Niveau niveau);
}
