/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Salle;
import com.school.IbnalHaytham.service.SalleService;
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
@RequestMapping("/salle")
public class SalleController {
    
    @Autowired SalleService salleService;
    
    @GetMapping("/all")
    public List<Salle> getModules(){
        return salleService.getSalles();
    }
    
    @PostMapping("/save")
    public String saveSalle(@RequestBody Salle salle){
        return salleService.saveSalle(salle);
    }
    
    @PutMapping("/update")
    public String updateSalle(@RequestBody Salle salle){
        return salleService.updateSalle(salle);
    }
    
    @DeleteMapping("/delete")
    public String removeSalle(@RequestBody Salle salle){
        return salleService.removeSalle(salle);
    }
}
