/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author abbasturki.elias
 */
@Entity
public class Groupe implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGroupe;
    private String libelle;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupe", fetch = FetchType.LAZY)
    private List<Seance> seanceList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGroupe", fetch = FetchType.LAZY)
    private List<Inscription> inscList;
    
    public Groupe() {
    }

    public Groupe(String libelle, Module idModule) {
        this.libelle = libelle;
    }

    public Integer getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Seance> getSeanceList() {
        return seanceList;
    }

    public void setSeanceList(List<Seance> seanceList) {
        this.seanceList = seanceList;
    }

    public List<Inscription> getInscList() {
        return inscList;
    }

    public void setInscList(List<Inscription> inscList) {
        this.inscList = inscList;
    }

    @Override
    public String toString() {
        return "Groupe{" + "idGroupe=" + idGroupe + ", libelle=" + libelle + '}';
    }

}
