package com.mycompany.verificaradeudados;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {    
    public static void main(String[] args) throws FileNotFoundException {
        String nombreArchivo = "Presupuesto RADIO 2020";
        String rutaArchivo = "D:/Escritorio/Presupuesto RADIO 2020.xlsx";
        String hoja = "Seguimiento de Clientes";
        int columnaDePago = 2;

        //FileInputStream file = new FileInputStream(new File(rutaArchivo));
        File file = new File(rutaArchivo);
        InputStream inp = new FileInputStream(file);

        
        try (inp){                             
            //Leer archivo excel
            //XSSFWorkbook workbook = new XSSFWorkbook(file);  
            Workbook workbook = WorkbookFactory.create(file);
            
            //obtener la hoja que se va leer
            //XSSFSheet sheet = workbook.getSheetAt(0);
            Sheet sheet = workbook.getSheetAt(0);
            
            //------
            /*int iRow = 1;
            Row row = sheet.getRow(iRow);
            while(row!=null) 
            {
                Cell cell = row.getCell(0);  
                String value = cell.getStringCellValue();
                System.out.println("Valor de la celda es " + value);
                cell.setCellValue("hola");
                iRow++;  
                row = sheet.getRow(iRow);
            }*/
            
            
            
            //------
            
            //obtener todas las filas de la hoja excel
            int iRow = 1;
            //En qué fila empezar
            Row row = sheet.getRow(iRow);
            //se recorre todas las filas
            while (row != null) {
                //se obtiene la celda de pago de dicha fila
                Cell cell = row.getCell(2);
                if (cell.getStringCellValue() != null){
                    cell.setCellValue("Adeuda");
                }
                
                /*cell.getCellType();
                double value = cell.getNumericCellValue();
                String valueStr = Double.toString(value);
                System.out.println("Valor de la celda es " + value);

                if (valueStr == "" || valueStr == "NA" || valueStr == "na") {
                    cell.setCellValue("Adeuda");
                } else {
                    System.out.println(cell.getStringCellValue());
                }   */  
                iRow++;
                row = sheet.getRow(iRow);
            }
            
            
            FileOutputStream outputStream = new FileOutputStream(rutaArchivo);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (Exception e){
            e.getMessage();
        }
    }
    
}