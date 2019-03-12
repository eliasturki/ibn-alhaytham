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
public class GainVo {
    
    
    private Integer idGain;
    private Integer idNiveau;
    private Integer idModule;
    private long prix;

    public GainVo() {
    }

    public GainVo(Integer idNiveau, Integer idModule, long prix) {
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
    
    public Integer getIdNiveau() {
        return idNiveau;
    }

    public void setIdNiveau(Integer idNiveau) {
        this.idNiveau = idNiveau;
    }

    public Integer getIdModule() {
        return idModule;
    }

    public void setIdModule(Integer idModule) {
        this.idModule = idModule;
    }
    
    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }
    
    
}
