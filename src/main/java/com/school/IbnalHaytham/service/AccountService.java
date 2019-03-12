/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;


import com.school.IbnalHaytham.model.AppRole;
import com.school.IbnalHaytham.model.AppUser;
import java.util.List;

/**
 *
 * @author abbasturki.elias
 */
public interface AccountService {
    
//    public AppUser saveUser(AppUser user);
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUser(String username,String roleName);
    public AppUser loadUserByUsername(String username);
    
}
