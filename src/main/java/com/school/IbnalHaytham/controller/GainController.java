/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.controller;

import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.vo.GainVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.school.IbnalHaytham.service.GainService;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author abbasturki.elias
 */
@RestController()
@RequestMapping("/gain")
public class GainController {
    
    @Autowired GainService gainService;
    
    @GetMapping("/all")
    public List<Gain> getGain(){
        return gainService.getGains();
    }
    
    @PostMapping("/save")
    public String saveGain(@RequestBody GainVo gainVo){
        return gainService.saveGain(gainVo);
    }
    
//    @PutMapping("/update")
//    public String updateGain(@RequestBody Gain gain){
//        return GainService.updateGain(gain);
//    }
    
    @PatchMapping("/update")
    public String updateGain(@RequestBody GainVo gainVo){
        return gainService.updateGain(gainVo);
    }
    
    @DeleteMapping("/delete")
    public String removeGain(@RequestBody GainVo gainVo){
        return gainService.removeGain(gainVo);
    }
    
    @GetMapping("/levelModules/{id}")
    public List<Module> getLevelModules(@PathVariable(name = "id") Integer idNiveau){
        return gainService.searchModuleByLevel(idNiveau);
    }
}
