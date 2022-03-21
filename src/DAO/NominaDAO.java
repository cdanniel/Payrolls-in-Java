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
public class NominaDAO {
    
    
    public NominaDAO(){
        
    }
    
    public void NominasMenores(int idNomina) {

        SessionFactory sf = null;
        Session sesion = null;
        Transaction tx;

        sf = HibernateUtil.getSessionFactory();
        sesion = sf.openSession();
        tx = sesion.beginTransaction();

        String borrado = "DELETE Nomina n WHERE n.idNomina=:param1";
        sesion.createQuery(borrado).setParameter("param1", idNomina).executeUpdate();
        tx.commit();
    }
    
}
