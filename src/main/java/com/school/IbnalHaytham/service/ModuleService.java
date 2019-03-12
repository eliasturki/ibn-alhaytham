/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.model.Module;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */

public interface ModuleService {
    
    public List<Module> getModules();
    public String saveModule(Module module);
    public String updateModule(Module module);
    public String removeModule(Module module);
    
}
