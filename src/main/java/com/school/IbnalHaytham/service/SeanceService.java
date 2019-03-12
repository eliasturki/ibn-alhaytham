/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Seance;
import com.school.IbnalHaytham.vo.SeanceVo;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface SeanceService {
    
    public List<Seance> getSeances();
    public String saveSeance(SeanceVo seanceVo);
    public String updateSeance(SeanceVo seanceVo);
    public String removeSeance(SeanceVo seanceVo);
    
}
