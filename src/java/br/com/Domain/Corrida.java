/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Domain;

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
 * @author JARVIS
 */
@Entity
@Table(name="Corrida")
public class Corrida {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    
    @NotNull
    @Column(name="classificacao")
    private int classificacao;
    
    @ManyToOne
    @JoinColumn(name="id_piloto", referencedColumnName="idpiloto")
    private Piloto piloto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
    
    
}
