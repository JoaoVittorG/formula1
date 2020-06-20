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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danie
 */

@Entity
@Table(name="Funcionario")
public class Funcionario implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idfuncionario;
    
    @Column(name="nomeFuncionario")
    private String nomeFuncionario;
    
    @Column(name="cargoFuncionario")
    private String cargoFuncionario;
    
    @ManyToOne
    @JoinColumn(name="id_equipe", referencedColumnName="idequipe")
    private Equipe equipe;

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.idfuncionario);
        hash = 53 * hash + Objects.hashCode(this.nomeFuncionario);
        hash = 53 * hash + Objects.hashCode(this.cargoFuncionario);
        hash = 53 * hash + Objects.hashCode(this.equipe);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.nomeFuncionario, other.nomeFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.cargoFuncionario, other.cargoFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.idfuncionario, other.idfuncionario)) {
            return false;
        }
        if (!Objects.equals(this.equipe, other.equipe)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idfuncionario=" + idfuncionario + ", nomeFuncionario=" + nomeFuncionario + ", cargoFuncionario=" + cargoFuncionario + ", equipe=" + equipe + '}';
    }
    
    }
