/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Seance;
import com.school.IbnalHaytham.service.SeanceService;
import com.school.IbnalHaytham.vo.SeanceVo;
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
 */
@RestController()
@RequestMapping("/seance")
public class SeanceController {
    
    @Autowired 
    private SeanceService seanceService;
    
    @GetMapping("/all")
    public List<Seance> getSeances(){
        return seanceService.getSeances();
    }
    
    @PostMapping("/save")
    public String saveSeance(@RequestBody SeanceVo seanceVo){
        return seanceService.saveSeance(seanceVo);
    }
    
//    @PutMapping("/update")
//    public String updateGain(@RequestBody Gain gain){
//        return GainService.updateGain(gain);
//    }
    
    @PatchMapping("/update")
    public String updateSeance(@RequestBody SeanceVo seanceVo){
        return seanceService.updateSeance(seanceVo);
    }
    
    @DeleteMapping("/delete")
    public String removeSeance(@RequestBody SeanceVo seanceVo){
        return seanceService.removeSeance(seanceVo);
    }
    
}
