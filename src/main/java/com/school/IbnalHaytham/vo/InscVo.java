/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.IbnalHaytham.vo;

/**
 *
 * @author abbasturki.elias
 * 
 */
public class InscVo {
    
    private Integer idInsc;
    private String statut;
    private Integer idUser;
    private Integer idGain;
    private Integer idGroupe;

    public InscVo() {
    }

    public InscVo(String statut, Integer idUser, Integer idGain, Integer idGroupe) {
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdGain() {
        return idGain;
    }

    public void setIdGain(Integer idGain) {
        this.idGain = idGain;
    }

    public Integer getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(Integer idGroupe) {
        this.idGroupe = idGroupe;
    }
    
    
}
