/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.Domain.Equipe;
import br.com.Domain.Funcionario;
import br.com.Service.EquipeService;
import br.com.Service.FuncionarioService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import br.com.util.UtilMensagens;
/**
 *
 * @author danie
 */

@SessionScoped
@ManagedBean(name="funcionarioMB")
public class FuncionarioController implements Serializable{
    private List<Funcionario> funcionarios;
    private Funcionario funcionario;
    private FuncionarioService funcionarioService = new FuncionarioService();
    private EquipeService equipeService = new EquipeService();
    private List<Equipe> equipes;
    
    public FuncionarioController() {
        listar();
        this.funcionario = new Funcionario();
    }
    
    public void listar(){
        funcionarios = funcionarioService.listar();
    }
    
    public String listagem(){
        listar();
        return "/private/cadastros/funcionario/list.xhtml?faces-redirect=true";
    }
    public String novo(){
        this.equipes = equipeService.listar();
        this.funcionario = new Funcionario();
        return "/private/cadastros/funcionario/new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String buscarDados(Funcionario funcionario){
        this.funcionario = funcionario;
        this.equipes = equipeService.listar();
        return "/private/cadastros/funcionario/alter.xhtml?faces-redirect=true";
    }
    
    public String alterar(){
        funcionarioService.alterar(funcionario);
        this.listar();
        return "/private/cadastros/funcionario/list.xhtml?faces-redirect=true";
    }
    
    public String excluir(Funcionario funcionario){
        funcionarioService.excluir(funcionario);
        this.listar();
        return "/private/cadastros/funcionario/list.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
       if(funcionarioService.inserir(funcionario)){
            UtilMensagens.mensagemSucesso("Sucesso", "Registro salvo com sucesso");
            listar();
            return "/private/cadastros/funcionario/list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o registro.");
        return null ;      
       
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public FuncionarioService getFuncionarioService() {
        return funcionarioService;
    }

    public void setFuncionarioService(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
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
