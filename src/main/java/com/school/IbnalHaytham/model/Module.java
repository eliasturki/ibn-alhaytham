/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Module implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idModule;
    private String libelle;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModule", fetch = FetchType.LAZY)
    private List<Gain> gainList;
    
    
    public Module() {
    }

    public Module(String libelle) {
        this.libelle = libelle;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
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
        return "Module{" + "idModule=" + idModule + ", libelle=" + libelle + '}';
    }

}
