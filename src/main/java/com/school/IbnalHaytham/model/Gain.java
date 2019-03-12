/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author abbasturki.elias
 * 
 */
@Entity
public class Gain implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGain;
    
   //@JsonIgnore
    @JoinColumn(name = "idNiveau", referencedColumnName = "idNiveau")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Niveau idNiveau;
 
   // @JsonIgnore
    @JoinColumn(name = "idModule", referencedColumnName = "idModule")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Module idModule;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idGain", fetch = FetchType.LAZY)
    private List<Inscription> inscList;
    
    private long prix;

    public Gain() {
    }

    public Gain(Niveau idNiveau, Module idModule, long prix) {
        this.idNiveau = idNiveau;
        this.idModule = idModule;
        this.prix = prix;
    }

    public Integer getIdGain() {
        return idGain;
    }

    public void setIdGain(Integer idGain) {
        this.idGain = idGain;
    }

    public Niveau getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Niveau idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Module getIdModule() {
        return idModule;
    }

    public void setIdModule(Module idModule) {
        this.idModule = idModule;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public List<Inscription> getInscList() {
        return inscList;
    }

    public void setInscList(List<Inscription> inscList) {
        this.inscList = inscList;
    }

    @Override
    public String toString() {
        return "Gain{" + "idGain=" + idGain + ", idNiveau=" + idNiveau + ", idModule=" + idModule + ", prix=" + prix + '}';
    }
    
    
    
}
