/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import DAO.CategoriasDAO;
import DAO.EmpresasDAO;
import DAO.NominaDAO;
import DAO.TrabajadorDAO;
import POJOS.Empresas;
import POJOS.Trabajadorbbdd;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Practica1 {
    
    public static void main(String[] args) {
        
        CategoriasDAO daoCategorias = new CategoriasDAO();
        EmpresasDAO daoEmpresas  = new EmpresasDAO();
        NominaDAO daoNomina = new NominaDAO();
        TrabajadorDAO daoTrabajador = new TrabajadorDAO();
        
        Scanner lectura = new Scanner (System.in);
        System.out.println("Ingrese el CIF: ");
        String CIF = lectura.next();
        
        List<Empresas> listadoEmpresas = daoEmpresas.listaEmpresas();
        
        Empresas empresaporCIF = daoEmpresas.empresaPorCIF(CIF);
        System.out.println(empresaporCIF.getNombre());
        
        List<Trabajadorbbdd> listaTrabajadores = daoTrabajador.listaTrabajadoresEmpresa(empresaporCIF.getIdEmpresa());
        
        for(int i=0; i < listaTrabajadores.size(); i++){
            
            System.out.println(listaTrabajadores.get(i).getNombre() + " " + listaTrabajadores.get(i).getApellido1() + " " + listaTrabajadores.get(i).getApellido2() + " " + 
            listaTrabajadores.get(i).getNifnie() + " " + listaTrabajadores.get(i).getCategorias().getNombreCategoria() + " " + listaTrabajadores.get(i).crearListaNominas().size());
            
        }
                
                
            
             
        
    }
    
}
