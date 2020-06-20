/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Domain;

/**
 *
 * @author danie
 */

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Piloto")
public class Piloto implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idpiloto;
    
    @NotNull
    @Column(name="nomePiloto")
    private String nomePiloto;
    
    @Column(name="pontuacaoPiloto")
    private Integer pontuacaoPiloto;     
    
    @ManyToOne
    @JoinColumn(name="id_equipe", referencedColumnName="idequipe")
    private Equipe equipe;

    public Integer getIdpiloto() {
        return idpiloto;
    }

    public void setIdpiloto(Integer idpiloto) {
        this.idpiloto = idpiloto;
    }

    public Integer getPontuacaoPiloto() {
        return pontuacaoPiloto;
    }

    public void setPontuacaoPiloto(Integer pontuacaoPiloto) {
        this.pontuacaoPiloto = pontuacaoPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idpiloto);
        hash = 19 * hash + Objects.hashCode(this.pontuacaoPiloto);
        hash = 19 * hash + Objects.hashCode(this.nomePiloto);
        hash = 19 * hash + Objects.hashCode(this.equipe);
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
        final Piloto other = (Piloto) obj;
        if (!Objects.equals(this.nomePiloto, other.nomePiloto)) {
            return false;
        }
        if (!Objects.equals(this.idpiloto, other.idpiloto)) {
            return false;
        }
        if (!Objects.equals(this.pontuacaoPiloto, other.pontuacaoPiloto)) {
            return false;
        }
        if (!Objects.equals(this.equipe, other.equipe)) {
            return false;
        }
        return true;
    }
    
    
}
