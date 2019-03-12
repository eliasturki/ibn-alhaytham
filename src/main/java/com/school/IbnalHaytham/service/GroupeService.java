/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Groupe;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface GroupeService {
    
    public List<Groupe> getGroupes();
    public String saveGroupe(Groupe groupe);
    public String updateGroupe(Groupe groupe);
    public String removeGroupe(Groupe groupe);
    
}
