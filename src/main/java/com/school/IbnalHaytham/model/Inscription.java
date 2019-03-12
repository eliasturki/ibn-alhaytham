/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author abbasturki.elias
 */
@Entity
public class Inscription implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsc;
    private Date date;
    private String statut;
    
    @JoinColumn(name = "idUser", referencedColumnName = "idUser")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private AppUser idUser;
    
    @JoinColumn(name = "idGain", referencedColumnName = "idGain")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Gain idGain;
    
    @JoinColumn(name = "idGroupe", referencedColumnName = "idGroupe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groupe idGroupe;

    public Inscription() {
    }

    public Inscription(Date date, String statut, AppUser idUser, Gain idGain, Groupe idGroupe) {
        this.date = date;
        this.statut = statut;
        this.idUser = idUser;
        this.idGain = idGain;
        this.idGroupe = idGroupe;
    }

    public Integer getIdInsc() {
        return idInsc;
    }

    public void setIdInsc(Integer idInsc) {
        this.idInsc = idInsc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public AppUser getIdUser() {
        return idUser;
    }

    public void setIdUser(AppUser idUser) {
        this.idUser = idUser;
    }

    public Gain getIdGain() {
        return idGain;
    }

    public void setIdGain(Gain idGain) {
        this.idGain = idGain;
    }

    public Groupe getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Groupe idGroupe) {
        this.idGroupe = idGroupe;
    }

    
}
