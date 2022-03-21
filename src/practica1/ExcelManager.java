/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author PC
 */
public class ExcelManager {
    
    
    public ExcelManager(){
        
    }
    
    public List<String> sacarDNI(){
        List<String> listadoDNI =  new ArrayList<String>();
        String nombreArchivo = "SistemasInformacionII.xlsx";
        String rutaArchivo = "C:\\Users\\PC\\Documents\\NetBeansProjects\\Practica1\\resources\\" + nombreArchivo;
        String hoja = "Hoja1";
 
        try (FileInputStream file = new FileInputStream(new File(rutaArchivo))) {
            // leer archivo excel
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            //obtener la hoja que se va leer
            XSSFSheet sheet = worbook.getSheetAt(4);
            //obtener todas las filas de la hoja excel
            Iterator<Row> rowIterator = sheet.iterator();
 
            Row row;
            // se recorre cada fila hasta el final
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                //se obtiene las celdas por fila
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                //se recorre cada celda
                while (cellIterator.hasNext()) {
                    // se obtiene la celda en específico y se la imprime
                    cell = cellIterator.next();
                    if(cell.getColumnIndex() == 0 && cell.getRowIndex() != 0){
                        listadoDNI.add(cell.getStringCellValue());
                    }

                }
                
            }
        } catch (Exception e) {
            e.getMessage();
        }
        
        return listadoDNI;
    }
    
}
