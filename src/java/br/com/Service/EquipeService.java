package br.com.Service;

import br.com.Dao.EquipeDao;
import br.com.Domain.Equipe;
import java.util.List;


public class EquipeService {
    private EquipeDao equipeDao = new EquipeDao();
    
    public List<Equipe> listar(){
        return equipeDao.listar();
    }
    
    public Equipe consultar(Integer id){
        return equipeDao.consultar(id);     
    }    
    
    public boolean inserir(Equipe equipe){
        return equipeDao.inserir(equipe);
    }
    
    public boolean alterar(Equipe equipe){
        return equipeDao.alterar(equipe);
    }
    
    public boolean excluir(Equipe equipe){
        return equipeDao.excluir(equipe);
    }
}
