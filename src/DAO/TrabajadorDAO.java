/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Trabajadorbbdd;
import java.util.ArrayList;
import java.util.List;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author PC
 */
public class TrabajadorDAO {
   
    
    public TrabajadorDAO(){
        
    }
    
    
    public List<Trabajadorbbdd> listaTrabajadoresEmpresa(int idEmpresa){
        List<Trabajadorbbdd> listaTrabajadores = new ArrayList<Trabajadorbbdd>();
        
        SessionFactory sf = null;
        Session session = null;
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        
        String consulta = "from Trabajadorbbdd where empresas.idEmpresa =" + idEmpresa;
        Query query = session.createQuery(consulta);
        //query.setParameter("y", idEmpresa);
        //System.out.println(query.toString());
        listaTrabajadores = query.list();
        return listaTrabajadores;
    }
    
}
