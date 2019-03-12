/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Niveau implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNiveau;
    private String libelle;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNiveau", fetch = FetchType.LAZY)
    private List<Gain> gainList;

    public Niveau() {
    }

    public Niveau(String libelle) {
        this.libelle = libelle;
    }

    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Gain> getGainList() {
        return gainList;
    }

    public void setGainList(List<Gain> gainList) {
        this.gainList = gainList;
    }

    @Override
    public String toString() {
        return "Niveau{" + "idNiveau=" + idNiveau + ", libelle=" + libelle + '}';
    }
    
    
    
}
