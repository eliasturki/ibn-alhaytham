/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.model;

import java.io.Serializable;
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
public class Seance implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeance;
    private String jour;
    private String heurDebut;
    private String heurFin;
    
    @JoinColumn(name = "idSalle", referencedColumnName = "idSalle")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Salle idSalle;
    
    @JoinColumn(name = "idGroupe", referencedColumnName = "idGroupe")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groupe idGroupe;

    public Seance() {
    }

    public Seance(String jour, String heurDebut, String heurFin, Salle idSalle, Groupe idGroupe) {
        this.jour = jour;
        this.heurDebut = heurDebut;
        this.heurFin = heurFin;
        this.idSalle = idSalle;
        this.idGroupe = idGroupe;
    }

    public Integer getIdSeance() {
        return idSeance;
    }

    public void setIdSeance(Integer idSeance) {
        this.idSeance = idSeance;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeurDebut() {
        return heurDebut;
    }

    public void setHeurDebut(String heurDebut) {
        this.heurDebut = heurDebut;
    }

    public String getHeurFin() {
        return heurFin;
    }

    public void setHeurFin(String heurFin) {
        this.heurFin = heurFin;
    }

    public Salle getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Salle idSalle) {
        this.idSalle = idSalle;
    }

    public Groupe getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Groupe idGroupe) {
        this.idGroupe = idGroupe;
    }

    @Override
    public String toString() {
        return "Seance{" + "idSeance=" + idSeance + ", jour=" + jour + ", heurDebut=" + heurDebut + ", heurFin=" + heurFin + ", idSalle=" + idSalle + ", idGroupe=" + idGroupe + '}';
    }
    
    
}
