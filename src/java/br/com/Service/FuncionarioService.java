/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Service;

import br.com.Dao.FuncionarioDao;
import br.com.Domain.Equipe;
import br.com.Domain.Funcionario;
import java.util.List;

/**
 *
 * @author danie
 */
public class FuncionarioService {
   private FuncionarioDao funcionarioDao = new FuncionarioDao();
    
   public void inicializarHibernate(){
        funcionarioDao.inicializarHibernate();
    }
   
    public List<Funcionario> listar(){
        return funcionarioDao.listar();
    }
    
    public Funcionario consultar(Integer id){
        return funcionarioDao.consultar(id);     
    }    
    
    public boolean inserir(Funcionario funcionario){
        return funcionarioDao.inserir(funcionario);
    }
    
    public boolean alterar(Funcionario funcionario){
        return funcionarioDao.alterar(funcionario);
    }
    
    public boolean excluir(Funcionario funcionario){
        return funcionarioDao.excluir(funcionario);
    }
}
