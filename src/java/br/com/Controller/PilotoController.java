/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.Domain.Equipe;
import br.com.Domain.Piloto;
import br.com.Service.EquipeService;
import br.com.Service.PilotoService;
import br.com.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author danie
 */
@SessionScoped
@ManagedBean(name="pilotoMB")
public class PilotoController implements Serializable{
    private List<Piloto> pilotos;
    private Piloto piloto;
    private PilotoService pilotoService = new PilotoService();
    private EquipeService equipeService = new EquipeService();
    private List<Equipe> equipes;
    
    public PilotoController() {
        listar();
        this.piloto = new Piloto();
    }
    
    public void listar(){
        pilotos = pilotoService.listar();
    }
    
    public String listagem(){
        listar();
        return "/private/cadastros/piloto/list.xhtml?faces-redirect=true";
    }
    public String novo(){
        this.equipes = equipeService.listar();
        this.piloto = new Piloto();
        return "/private/cadastros/piloto/new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String buscarDados(Piloto piloto){
        this.piloto = piloto;
        this.equipes = equipeService.listar();
        return "/private/cadastros/piloto/alter.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        pilotoService.alterar(piloto);
        this.listar();
        return "/private/cadastros/piloto/list.xhtml?faces-redirect=true";
    }
    
    public String excluir(Piloto piloto){
        pilotoService.excluir(piloto);
        this.listar();
        return "/private/cadastros/piloto/list.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
       piloto.setPontuacaoPiloto(0);
       if(pilotoService.inserir(piloto)){
            UtilMensagens.mensagemSucesso("Sucesso", "Registro salvo com sucesso");
            listar();
            return "/private/cadastros/piloto/list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o registro.");
        return null ;      
       
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public PilotoService getPilotoService() {
        return pilotoService;
    }

    public void setPilotoService(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    public EquipeService getEquipeService() {
        return equipeService;
    }

    public void setEquipeService(EquipeService equipeService) {
        this.equipeService = equipeService;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }
    
    
    
}
