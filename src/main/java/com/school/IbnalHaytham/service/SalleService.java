/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Salle;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface SalleService {
    
    public List<Salle> getSalles();
    public String saveSalle(Salle salle);
    public String updateSalle(Salle salle);
    public String removeSalle(Salle salle);
}
