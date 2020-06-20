/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import br.com.Domain.Corrida;
import br.com.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JARVIS
 */
public class CorridaDao {
    public List<Corrida> listar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            List<Corrida> corrida = session.createQuery("from Corrida order by classificacao").list();
            session.getTransaction().commit();         
            return corrida;
         }catch(Exception e){
            e.printStackTrace();                          
            session.getTransaction().rollback();          
            return null;
        }
    }
    
    public boolean inserir(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();             
        try{
            session.save(corrida);
            session.getTransaction().commit();     
            return true;
        }catch(Exception e){
            e.printStackTrace();                        
            session.getTransaction().rollback();        
            return false;
        }
    }

    
    public boolean excluir(Corrida corrida) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();        
        try{
            session.delete(corrida);
            session.getTransaction().commit();    
            return true;
        }catch(Exception e){
            e.printStackTrace();                       
            session.getTransaction().rollback();       
            return false;
        }
    }
}
