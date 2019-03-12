/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Groupe;
import com.school.IbnalHaytham.service.GroupeService;
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
@RequestMapping("/groupe")
public class GroupeController {
    
    @Autowired GroupeService groupeService;
    
    @GetMapping("/all")
    public List<Groupe> getModules(){
        return groupeService.getGroupes();
    }
    
    @PostMapping("/save")
    public String saveModule(@RequestBody Groupe groupe){
        return groupeService.saveGroupe(groupe);
    }
    
    @PutMapping("/update")
    public String updateModule(@RequestBody Groupe groupe){
        return groupeService.updateGroupe(groupe);
    }
    
    @DeleteMapping("/delete")
    public String removeModule(@RequestBody Groupe groupe){
        return groupeService.removeGroupe(groupe);
    }
    
}
