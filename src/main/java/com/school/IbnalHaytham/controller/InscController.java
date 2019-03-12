/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Inscription;
import com.school.IbnalHaytham.service.InscService;
import com.school.IbnalHaytham.vo.InscVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author abbasturki.elias
 * 
 */

@RestController()
@RequestMapping("/insc")
public class InscController {
    
    @Autowired InscService inscService;
    
    @GetMapping("/all")
    public List<Inscription> getInsc(){
        return inscService.getInscriptions();
    }
    
    @PostMapping("/save")
    public String saveInsc(@RequestBody InscVo inscVo){
        return inscService.saveInsc(inscVo);
    }
    
//    @PutMapping("/update")
//    public String updateGain(@RequestBody Gain gain){
//        return gainService.updateGain(gain);
//    }
    
    @PatchMapping("/update")
    public String updateInsc(@RequestBody InscVo inscVo){
        return inscService.updateInsc(inscVo);
    }
    
    @DeleteMapping("/delete")
    public String removeInsc(@RequestBody InscVo inscVo){
        return inscService.removeInsc(inscVo);
    }
   
    
}
