/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.service;

import com.school.IbnalHaytham.dao.RoleRepository;
import com.school.IbnalHaytham.dao.UserRepository;
import com.school.IbnalHaytham.model.AppRole;
import com.school.IbnalHaytham.model.AppUser;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author abbasturki.elias
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Override
    public AppUser saveUser(AppUser au) {
        AppUser user = userRepository.findByUsername(au.getUsername());
        if (user != null) {
            throw new RuntimeException("Nom d'utilisateur existe déjà");
        }
        //if(!password.equals(confirmedPassword))throw  new RuntimeException("Veuillez confirmer votre mot de passe");
        AppUser appUser = new AppUser();
        appUser.setUsername(au.getUsername());
        String hashPW = bCryptPasswordEncoder.encode(au.getMotdepasse());
        appUser.setMotdepasse(hashPW);
        appUser.setNom(au.getNom());
        appUser.setPrenom(au.getPrenom());
        String birthday = df.format(au.getDate_naiss());
        try {
            appUser.setDate_naiss(df.parse(birthday));
        } catch (ParseException ex) {
            Logger.getLogger(AccountServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //appUser.setDate_naiss(au.getDate_naiss());
        appUser.setAdresse(au.getAdresse());
        appUser.setEmail(au.getEmail());
        appUser.setTele1(au.getTele1());
        appUser.setTele2(au.getTele2());
        appUser.setSexe(au.getSexe());
        appUser.setActived(false);
        userRepository.save(appUser);
        addRoleToUser(au.getUsername(), "USER");
        return appUser;
    }
    
    @Override
    public AppRole saveRole(AppRole role) {
        return roleRepository.save(role);
    }
    
    @Override
    public void addRoleToUser(String username, String roleName) {
        AppRole role = roleRepository.findByRoleName(roleName);
        AppUser user = userRepository.findByUsername(username);
        user.getRoles().add(role);
    }
    
    @Override
    public AppUser loadUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
}
