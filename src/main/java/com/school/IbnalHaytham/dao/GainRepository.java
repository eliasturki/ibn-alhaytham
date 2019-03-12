/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;

import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.model.Niveau;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abbasturki.elias
 */

public interface GainRepository extends JpaRepository<Gain,Integer>{
    @Query("select g from Gain g where g.idModule=:X and g.idNiveau=:Y")
    public Gain findByModuleAndNiveau(@Param("X")Module module,@Param("Y")Niveau niveau);
    
    
    @Query("select g from Gain g where g.idNiveau=:Y")
    public List<Gain> findByLevel(@Param("Y")Niveau niveau);

}
