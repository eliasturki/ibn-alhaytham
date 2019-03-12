/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.model.Niveau;
import com.school.IbnalHaytham.service.ModuleService;
import com.school.IbnalHaytham.service.NiveauService;
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
@RequestMapping("/niveau")
public class NiveauController {
    
    @Autowired NiveauService niveauService;
    
    @GetMapping("/all")
    public List<Niveau> getModules(){
        return niveauService.getNiveau();
    }
    
    @PostMapping("/save")
    public String saveNiveau(@RequestBody Niveau niveau){
        return niveauService.saveNiveau(niveau);
    }
    
    @PutMapping("/update")
    public String updateNiveau(@RequestBody Niveau niveau){
        return niveauService.updateNiveau(niveau);
    }
    
    @DeleteMapping("/delete")
    public String removeNiveau(@RequestBody Niveau niveau){
        return niveauService.removeNiveau(niveau);
    }
    
}
