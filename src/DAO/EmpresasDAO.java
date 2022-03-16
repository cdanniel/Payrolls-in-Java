/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJOS.Nomina;
import DAO.EmpresasDAO;
import DAO.NominaDAO;
import DAO.TrabajadorDAO;
import POJOS.Empresas;
import POJOS.Nomina;
import POJOS.Trabajadorbbdd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import modelo.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author PC
 */
public class EmpresasDAO {
    
    
    public EmpresasDAO(){
        
    }
    
    
    public List<Empresas> listaEmpresas(){
        List<Empresas> listadoEmpresas  =  new ArrayList<Empresas>();
        
        SessionFactory sf = null;
        Session session = null;
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        
        String consulta = "SELECT n FROM Empresas n";
        Query query = session.createQuery(consulta);
        
        listadoEmpresas = query.list();
        
        return listadoEmpresas;
    }
    
    public Empresas empresaPorCIF(String CIF){
        Empresas empresa = new Empresas();
        
        SessionFactory sf = null;
        Session session = null;
        sf = HibernateUtil.getSessionFactory();
        session = sf.openSession();
        
        String consulta = "SELECT n FROM Empresas n WHERE n.cif=:y";
        Query query = session.createQuery(consulta);
        query.setParameter("y", CIF);
        empresa = (Empresas) query.list().get(0);
        
        return empresa;
    }
    
    public void actualizarNombreEmpresas(String CIF){
        
        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx;
        
        sf = HibernateUtil.getSessionFactory();
        sesion = sf.openSession();
        
        String consultaCIF = "SELECT e FROM Empresas e";
        Query sentencia = sesion.createQuery(consultaCIF);
        
        List<Empresas> empresas = sentencia.list();
        for(Empresas emp:empresas){
            if(!(emp.getCif().equals(CIF))){
            String nombre =emp.getNombre();

            emp.setNombre(nombre + "2022");
            tx = sesion.beginTransaction();
            sesion.saveOrUpdate(emp);
            tx.commit();
            }
        }
    }
    
}
