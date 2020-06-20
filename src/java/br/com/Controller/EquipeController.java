package br.com.Controller;

import br.com.Domain.Equipe;
import br.com.Service.EquipeService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


@SessionScoped
@ManagedBean(name="equipeMB")
public class EquipeController implements Serializable{
    private Equipe equipe = new Equipe();
    private List<Equipe> equipes;
    private EquipeService equipeService = new EquipeService();
    
    
    public EquipeController(){
        
        listar();
    }
    
    
    public void listar(){
        equipes = equipeService.listar();
    }
    
    public String listagem(){
        listar();
        return "/private/cadastros/equipe/list.xhtml?faces-redirect=true";
    }
    
    public String novo(){
        equipe = new Equipe();
        return "/private/cadastros/equipe/new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String buscarDados(Equipe equipe){
        this.equipe = equipe;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        equipeService.alterar(equipe);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    
    public String excluir(Equipe equipe){
        equipeService.excluir(equipe);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
       equipeService.inserir(equipe);
       this.listar();      
       return "/private/cadastros/equipe/list.xhtml?faces-redirect=true";
    } 

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = equipes;
    }

    public EquipeService getEquipeService() {
        return equipeService;
    }

    public void setEquipeService(EquipeService equipeService) {
        this.equipeService = equipeService;
    }
    
    
}
