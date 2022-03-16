package practica1;

import DAO.CategoriasDAO;
import DAO.EmpresasDAO;
import DAO.NominaDAO;
import DAO.TrabajadorDAO;
import POJOS.Empresas;
import POJOS.Nomina;
import POJOS.Trabajadorbbdd;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Practica1 {
    
    public static void main(String[] args) {
        
        //P1254785I
        
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
        
        //Ejercicio 2
        /*
        listadoEmpresas.removeAll(listadoEmpresas);
        
        daoEmpresas.actualizarNombreEmpresas(CIF);
        listadoEmpresas = daoEmpresas.listaEmpresas();
        System.out.println("Empresas actualizadas");
        for(Empresas emp:listadoEmpresas){
            System.out.println(emp.getNombre());
        }
        */
        //Ejercicio 3
        
        double mediaNominas = mediaNominas(listaTrabajadores);
        System.out.println("La media de las nominas es " + mediaNominas);
        
        List<Nomina> listaNominasSuperiores = listaNominasSuperioresMedia(mediaNominas, listaTrabajadores);
        List<Nomina> listaNominasInferiores = listaNominasInferioresMedia(mediaNominas, listaTrabajadores);
        System.out.println("Nominas superiores");
        for(int j = 0; j < listaNominasSuperiores.size(); j++){
            System.out.println(listaNominasSuperiores.get(j).getBrutoNomina());
        }
        System.out.println("Nominas inferiores");
        for(int j = 0; j < listaNominasInferiores.size(); j++){
            System.out.println(listaNominasInferiores.get(j).getBrutoNomina());
            //Llamada el metodo que las borra
        }
            
    }
    
    
    public static double mediaNominas(List<Trabajadorbbdd> listaTrabajadores){
        double media = 0;
        int cont = 0;
        for(int i = 0; i < listaTrabajadores.size(); i++){
            List<Nomina> listaNominas = listaTrabajadores.get(i).crearListaNominas();
            for(int j = 0; j < listaNominas.size(); j++){
                media = media + listaNominas.get(j).getBrutoNomina();
                cont++;
            }
        }
        
        media = media/cont;
        
        return media;
    }
    
    
    public static List<Nomina> listaNominasSuperioresMedia(double media, List<Trabajadorbbdd> listaTrabajadores){
        List<Nomina> listaNominas = new ArrayList<Nomina>();
        
        for(int i = 0; i < listaTrabajadores.size(); i++){
            for(int j = 0; j < listaTrabajadores.get(i).crearListaNominas().size(); j++){
                if(listaTrabajadores.get(i).crearListaNominas().get(j).getBrutoNomina() > media){
                    listaNominas.add(listaTrabajadores.get(i).crearListaNominas().get(j));
                }   
            }
        }
        
        return listaNominas;
    }
    
    public static List<Nomina> listaNominasInferioresMedia(double media, List<Trabajadorbbdd> listaTrabajadores){
        List<Nomina> listaNominas = new ArrayList<Nomina>();
        
        for(int i = 0; i < listaTrabajadores.size(); i++){
            for(int j = 0; j < listaTrabajadores.get(i).crearListaNominas().size(); j++){
                if(listaTrabajadores.get(i).crearListaNominas().get(j).getBrutoNomina() < media){
                    listaNominas.add(listaTrabajadores.get(i).crearListaNominas().get(j));
                }   
            }
        }
        
        return listaNominas;
    }
    
}
