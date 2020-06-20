/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Service;

import br.com.Dao.PilotoDao;
import br.com.Domain.Piloto;
import java.util.List;

/**
 *
 * @author JARVIS
 */
public class PilotoService {
    private PilotoDao pilotoDao = new PilotoDao();
    
   public void inicializarHibernate(){
        pilotoDao.inicializarHibernate();
    }
   
    public List<Piloto> listar(){
        return pilotoDao.listar();
    }
    
    public Piloto consultar(Integer id){
        return pilotoDao.consultar(id);     
    }    
    
    public boolean inserir(Piloto piloto){
        return pilotoDao.inserir(piloto);
    }
    
    public boolean alterar(Piloto piloto){
        return pilotoDao.alterar(piloto);
    }
    
    public boolean excluir(Piloto piloto){
        return pilotoDao.excluir(piloto);
    }
}
