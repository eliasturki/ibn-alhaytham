/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Inscription;
import com.school.IbnalHaytham.vo.InscVo;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface InscService {
    
    public List<Inscription> getInscriptions();
    public String saveInsc(InscVo inscVo);
    public String updateInsc(InscVo inscVo);
    public String removeInsc(InscVo inscVo);
    
}
