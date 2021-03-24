package com.mycompany.verificaradeudados;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;


public class Main {
    private static final String APPLICATION_NAME = "Verificador de Adeudados";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";    //credenciales para utilización de las API de google
    private static int filaEncabezadosPago = 2;

    
    //Se crea un objeto credencial
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        //Se cargan los usuarios que pueden acceder
        InputStream in = Main.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        //Genera el flujo y activa la solicitud de autorización del usuario.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("OAuth client");
    }

    
    
    
    public static void main(String... args) throws IOException, GeneralSecurityException {
        //Se genera una nueva API de Servicio de Cliente Autorizado
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();        
        final String spreadsheetId = "1E_L6e4wwq7Rew0yaCIzy3pWsaFWkc2q26sUIqLLT5jc";    //id de la hoja de cálculo a la que se accederá
        final String range = "Hoja 1!A1:I8";                          //Nombre de hoja e indicativo de inicio y fin de las celdas a las que se accederá
        
        //Servicio solicitado
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        //Respuesta concedida
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        //Se listan las respuestas para trabajarlas individualmente
        List<List<Object>> values = response.getValues();
        
                
        
        
        List row = values.get(filaEncabezadosPago);     //obtengo la fila de encabezados
        List<Integer> columnasPago = new ArrayList<>();
        int cantCeldas = row.size();
        
        //listar las columnas de pago
        for (int i = 0; i < cantCeldas; i++) {
            //se verifica que sea la columna de pagos y de serlo se agrega a la lista
            if (row.get(i).equals("Pago")) {
                columnasPago.add(i);
            }
        }
        
        System.out.println("LISTA DE DEUDORES:");
        
        //verificar que haya cumplido el pago de todos los meses
        //i es fila actual y j columna actual
        for (int i = filaEncabezadosPago +1; i < 8; i++) {
            System.out.println("_______________________________");
            row = values.get(i);
            //completo las celdas que no se cargaron
            int faltantes = cantCeldas - row.size();
            for (int k = 0; k < faltantes; k++) {
                row.add("");
            }
                        
            if (row.isEmpty()) {
                break;
            } else {
                for (int j : columnasPago) {
                    if (row.get(j).equals("")) {
                        System.out.printf("%s debe el mes de %s %n", row.get(0), values.get(0).get(j));
                    }
                }
            }
        }
    }
}