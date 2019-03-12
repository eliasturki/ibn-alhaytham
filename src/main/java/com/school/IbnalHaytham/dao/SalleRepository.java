/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;

import com.school.IbnalHaytham.model.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author abbasturki.elias
 */

public interface SalleRepository extends JpaRepository<Salle,Integer>{
    public Salle findByLibelle(String libelle);
}
