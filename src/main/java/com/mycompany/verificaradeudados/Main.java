package com.mycompany.verificaradeudados;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {    
    public static void main(String[] args) throws FileNotFoundException {
        String nombreArchivo = "Presupuesto RADIO 2020.xlsx";
        String rutaArchivo = "D:/Escritorio/" + nombreArchivo;
        String hoja = "Seguimiento de clientes ";
        int columnaDePagoInicial = 2;
        int filaEncabezado = 2;   
        DataFormatter formatter = new DataFormatter();

        //iniciar la comunicación con el archivo excel
        FileInputStream file = new FileInputStream(new File(rutaArchivo));
        
        try (file){                             
            //Leer archivo excel
            XSSFWorkbook workbook = new XSSFWorkbook(file);  
            
            //obtener la hoja que se va leer
            XSSFSheet sheet = workbook.getSheet(hoja);                   
            
            //Fila de Encabezados
            int iRow = filaEncabezado;
            
            Row rowEncabezado = sheet.getRow(iRow);
            int cantColumns = rowEncabezado.getLastCellNum();
            
            String pago = formatter.formatCellValue(rowEncabezado.getCell(columnaDePagoInicial));
       
            //Se realiza la operación para cada columna con nombre de encabezado "Pago"
            for (int i = 1; i <= cantColumns; i++) {    
                String s = formatter.formatCellValue(rowEncabezado.getCell(i));
                if (s == pago) {
                    //En qué fila empezar
                    Row row = sheet.getRow(iRow);
                    //se recorre todas las filas
                    while (row != null) {
                        //se obtiene la celda de pago de dicha fila
                        Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        //se verifican celdas vacías y con valores no numéricos
                        if (cell.getCellType() == CellType.BLANK || cell.getCellType() == CellType.STRING) {
                            cell.setCellValue("Adeuda");
                        }

                        iRow++;
                        row = sheet.getRow(iRow);
                    }
                    
                }
                iRow = filaEncabezado + 1;
            }
            
            
            
            
            //cerrar la comunicación con el archivo excel
            FileOutputStream outputStream = new FileOutputStream(rutaArchivo);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();

        } catch (Exception e){
            e.getMessage();
        }
    }
    
}