/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;

import com.school.IbnalHaytham.model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author abbasturki.elias
 * 
 */

public interface ModuleRepository extends JpaRepository<Module,Integer>{
    
    public Module findByLibelle(String libelle);
    
}
