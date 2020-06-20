/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danie
 */

@Entity
@Table(name="Equipe")
public class Equipe implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idequipe;
   
    @Column(name="nomeEquipe")
    private String nomeEquipe;

    public Equipe() {
        
    }

    public Equipe(Integer idequipe, String nomeEquipe) {
        this.idequipe = idequipe;
        this.nomeEquipe = nomeEquipe;
    }
    
    
    public Integer getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Integer idequipe) {
        this.idequipe = idequipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idequipe);
        hash = 97 * hash + Objects.hashCode(this.nomeEquipe);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        if (!Objects.equals(this.nomeEquipe, other.nomeEquipe)) {
            return false;
        }
        if (!Objects.equals(this.idequipe, other.idequipe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipe{" + "idequipe=" + idequipe + ", nomeEquipe=" + nomeEquipe + '}';
    }

       
    
}
