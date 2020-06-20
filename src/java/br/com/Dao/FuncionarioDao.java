/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import java.util.List;
import org.hibernate.Session;
import br.com.Domain.Funcionario;
import br.com.util.HibernateUtil;

/**
 *
 * @author danie
 */
public class FuncionarioDao {
    
    public void inicializarHibernate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.getTransaction().commit();
    }
    
    public Funcionario consultar(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();             
        try{
            Funcionario funcionario = (Funcionario) session.createQuery("from Funcionario where idfuncionario = " + id).uniqueResult();
            session.getTransaction().commit();   
            return funcionario;
        }catch(Exception e){
            e.printStackTrace();                             
            session.getTransaction().rollback();             
            return null;
        }
    }
    
    public List<Funcionario> listar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        try{
            List<Funcionario> funcionarios = session.createQuery("from Funcionario order by nomefuncionario").list();  
            session.getTransaction().rollback();             
            return funcionarios;
         }catch(Exception e){
            e.printStackTrace();                             
            session.getTransaction().rollback();             
            return null;
        }
    }
    
      public boolean alterar(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();           
        try{
            session.update(funcionario);
            session.getTransaction().commit();  
            return true;
        }catch(Exception e){
            e.printStackTrace();                         
            session.getTransaction().rollback();         
            return false;
        }
    }
    
    public boolean inserir(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();             
        try{
            session.save(funcionario);
            session.getTransaction().commit();           
            return true;
        }catch(Exception e){
            e.printStackTrace();                         
            session.getTransaction().rollback();         
            return false;
        }
    }

  
    public boolean excluir(Funcionario funcionario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();             
        try{
            session.delete(funcionario);
            session.getTransaction().commit();  
            return true;
        }catch(Exception e){
            e.printStackTrace();                         
            session.getTransaction().rollback();         
            return false;
        }
    }
}
