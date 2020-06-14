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
@Table(name="piloto")
public class PilotoDomain implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idequipe;
    
    @NotNull
    @Column(name="nome")
    private String nome;
    
    @Column(name="pontuacao")
    private Integer pont;
    
    @ManyToOne
    @JoinColumn(name="id-eq", referencedColumnName="id")
    private EquipeDomain equi;
}
