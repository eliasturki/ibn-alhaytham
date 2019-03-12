/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.dao;


import com.school.IbnalHaytham.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author abbasturki.elias
 */
@RepositoryRestResource
public interface UserRepository extends JpaRepository<AppUser,Integer>{
    public AppUser findByUsername(String username);
}
