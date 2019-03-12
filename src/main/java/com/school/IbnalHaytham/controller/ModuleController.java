/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.service.ModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 */
@RestController()
@RequestMapping("/module")
public class ModuleController {
    
    @Autowired ModuleService moduleService;
    
    @GetMapping("/all")
    public List<Module> getModules(){
        return moduleService.getModules();
    }
    
    @PostMapping("/save")
    public String saveModule(@RequestBody Module module){
        return moduleService.saveModule(module);
    }
    
    @PutMapping("/update")
    public String updateModule(@RequestBody Module module){
        return moduleService.updateModule(module);
    }
    
    @DeleteMapping("/delete")
    public String removeModule(@RequestBody Module module){
        return moduleService.removeModule(module);
    }
    
}
