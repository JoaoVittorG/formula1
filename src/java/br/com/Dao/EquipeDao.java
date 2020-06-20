/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import java.util.List;
import org.hibernate.Session;
import br.com.Domain.Equipe;
import br.com.util.HibernateUtil;

/**
 *
 * @author danie
 */
public class EquipeDao {
    
   public List<Equipe> listar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            List<Equipe> equipe = session.createQuery("from Equipe order by nomeequipe").list();
            session.getTransaction().commit();         
            return equipe;
         }catch(Exception e){
            e.printStackTrace();                          
            session.getTransaction().rollback();          
            return null;
        }
    }
    
    public Equipe consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();              
        try{
            Equipe equipe = (Equipe) session.createQuery("from Equipe where id = " + id).uniqueResult();
            session.getTransaction().commit();   
            return equipe;
        }catch(Exception e){
            e.printStackTrace();                    
            session.getTransaction().rollback();    
            return null;
        }
    }
    
    public boolean inserir(Equipe equipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();             
        try{
            session.save(equipe);
            session.getTransaction().commit();     
            return true;
        }catch(Exception e){
            e.printStackTrace();                        
            session.getTransaction().rollback();        
            return false;
        }
    }

    public boolean alterar(Equipe equipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();          
        try{
            session.update(equipe);
            session.getTransaction().commit();  
            return true;
        }catch(Exception e){
            e.printStackTrace();                
            session.getTransaction().rollback(); 
            return false;
        }
    }
    
    public boolean excluir(Equipe equipe) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();        
        try{
            session.delete(equipe);
            session.getTransaction().commit();    
            return true;
        }catch(Exception e){
            e.printStackTrace();                       
            session.getTransaction().rollback();       
            return false;
        }
    } 
}
