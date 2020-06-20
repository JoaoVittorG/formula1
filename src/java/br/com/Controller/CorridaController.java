/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.Domain.Corrida;
import br.com.Domain.Piloto;
import br.com.Service.CorridaService;
import br.com.Service.PilotoService;
import br.com.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name="corridaMB")
public class CorridaController implements Serializable{
    private Corrida corrida = new Corrida();
    private List<Corrida> corridas;
    private CorridaService corridaService = new CorridaService();
    private PilotoService pilotoService = new PilotoService();
    private List<Piloto> pilotos;
    private ArrayList<Piloto> pil;
    
    public CorridaController(){
        this.corrida = new Corrida();
        listar();
    }
    
    
    public void listar(){
        corridas = corridaService.listar();
    }
    
    public void adicionar(Piloto pil){
        this.pil.add(pil);
    }
    
    public String listagem(){
        listar();
        return "/private/cadastros/corrida/list.xhtml?faces-redirect=true";
    }
    public String novo(){
        pil = new ArrayList<>();
        this.pilotos = pilotoService.listar();
        this.corrida = new Corrida();
        return "/private/cadastros/corrida/new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "/index.xhtml?faces-redirect=true";
    }
    
    
    public String excluir(Corrida corrida){
        corridaService.excluir(corrida);
        this.listar();
        return "/private/cadastros/funcionario/list.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        
       if(corridaService.inserir(corrida)){
            UtilMensagens.mensagemSucesso("Sucesso", "Registro salvo com sucesso");
            listar();
            return "/index.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o registro.");
        return null ;      
       
    }

    public Corrida getCorrida() {
        return corrida;
    }

    public void setCorrida(Corrida corrida) {
        this.corrida = corrida;
    }

    public List<Corrida> getCorridas() {
        return corridas;
    }

    public void setCorridas(List<Corrida> corridas) {
        this.corridas = corridas;
    }

    public CorridaService getCorridaService() {
        return corridaService;
    }

    public void setCorridaService(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    public PilotoService getPilotoService() {
        return pilotoService;
    }

    public void setPilotoService(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }
    
    
    
    
}
