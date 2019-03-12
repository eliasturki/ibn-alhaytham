/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;

import com.school.IbnalHaytham.model.AppUser;
import com.school.IbnalHaytham.model.Gain;
import com.school.IbnalHaytham.model.Groupe;
import com.school.IbnalHaytham.model.Module;
import com.school.IbnalHaytham.model.Niveau;
import com.school.IbnalHaytham.model.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author abbasturki.elias
 */
public interface SeanceRepository extends JpaRepository<Seance,Integer>{
    @Query("select s from Seance s where s.jour=:X and s.heurDebut=:Y and s.heurFin=:Z and s.idGroupe=:W")
    public Seance findByGroupeAndSeance(@Param("X")String jour,@Param("Y")String heurDebut,@Param("Z")String heurFin,@Param("W")Groupe idGroupe);
}
