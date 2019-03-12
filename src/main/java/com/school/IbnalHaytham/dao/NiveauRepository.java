/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;

import com.school.IbnalHaytham.model.AppUser;
import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Inscription;
import com.school.IbnalHaytham.model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author abbasturki.elias
 */
public interface NiveauRepository extends JpaRepository<Niveau,Integer>{
    public Niveau findByLibelle(String libelle);
}
