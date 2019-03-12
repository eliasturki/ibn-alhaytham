/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;

import com.school.IbnalHaytham.model.AppUser;
import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Groupe;
import com.school.IbnalHaytham.model.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author abbasturki.elias
 */
public interface InscriptionRepository extends JpaRepository<Inscription,Integer>{
    @Query("select i from Inscription i where i.idUser=:X and i.idGroupe=:Y and i.idGain=:Z")
    public Inscription findByUserAndGroupe(@Param("X")AppUser appUser,@Param("Y")Groupe groupe,@Param("Z")Gain gain);
}
