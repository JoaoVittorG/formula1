/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Service;

import br.com.Dao.CorridaDao;
import br.com.Domain.Corrida;
import java.util.List;

/**
 *
 * @author JARVIS
 */
public class CorridaService {
    private CorridaDao corridaDao = new CorridaDao();
    
    public List<Corrida> listar(){
        return corridaDao.listar();
    }
    
    
    public boolean inserir(Corrida corrida){
        return corridaDao.inserir(corrida);
    }
    
    
    public boolean excluir(Corrida corrida){
        return corridaDao.excluir(corrida);
    }
}
