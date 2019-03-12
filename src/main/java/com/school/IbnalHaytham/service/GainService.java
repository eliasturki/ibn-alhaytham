/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.model.Niveau;
import com.school.IbnalHaytham.vo.GainVo;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface GainService {
    
    public List<Gain> getGains();
    public String saveGain(GainVo gainVo);
    public String updateGain(GainVo gain);
    public String removeGain(GainVo gain);
    public List<Module> searchModuleByLevel(Integer idNiveau);
    
}
