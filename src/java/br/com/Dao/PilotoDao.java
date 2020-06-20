/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import java.util.List;
import org.hibernate.Session;
import br.com.Domain.Piloto;
import br.com.util.HibernateUtil;

/**
 *
 * @author danie
 */
public class PilotoDao {
    
    public void inicializarHibernate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
    }
    
    public Piloto consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();            
        try{
            Piloto piloto = (Piloto) session.createQuery("from Piloto where idpiloto = " + id).uniqueResult();
            session.getTransaction().commit();   
            return piloto;
        }catch(Exception e){
            e.printStackTrace();                            
            session.getTransaction().rollback();            
            return null;
        }
    }
    
    public List<Piloto> listar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            List<Piloto> pilotos = session.createQuery("from Piloto order by nomePiloto").list();  
            session.getTransaction().rollback();            
            return pilotos;
         }catch(Exception e){
            e.printStackTrace();                           
            session.getTransaction().rollback();           
            return null;
        }
    }
    
    public boolean inserir(Piloto piloto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();              
        try{
            session.save(piloto);
            session.getTransaction().commit();              
            return true;
        }catch(Exception e){
            e.printStackTrace();                            
            session.getTransaction().rollback();            
            return false;
        }
    }
    
    public boolean excluir(Piloto piloto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();         
        try{
            session.delete(piloto);
            session.getTransaction().commit();   
            return true;
        }catch(Exception e){
            e.printStackTrace();                 
            session.getTransaction().rollback(); 
            return false;
        }
    }
    
    public boolean alterar(Piloto piloto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();              
        try{
            session.update(piloto);
            session.getTransaction().commit();   
            return true;
        }catch(Exception e){
            e.printStackTrace();                 
            session.getTransaction().rollback(); 
            return false;
        }
    }
}
