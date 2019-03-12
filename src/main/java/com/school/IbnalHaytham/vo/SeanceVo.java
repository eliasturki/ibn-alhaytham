/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.vo;

/**
 *
 * @author abbasturki.elias
 */
public class SeanceVo {
    
    private Integer idSeance;
    private String jour;
    private String heurDebut;
    private String heurFin;
    private Integer idSalle;
    private Integer idGroupe;

    public SeanceVo() {
    }

    public SeanceVo(String jour, String heurDebut, String heurFin, Integer idSalle, Integer idGroupe) {
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

    public Integer getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }

    public Integer getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }
    
    
    
}
