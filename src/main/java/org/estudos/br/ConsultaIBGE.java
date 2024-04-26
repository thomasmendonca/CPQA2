package org.estudos.br;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ConsultaIBGE {

    private static final String REGIOES_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes/";

   
    private static final String ESTADOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

    
    private static final String DISTRITOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/distritos/";

    





    
    public static String consultarRegiao(int id) throws IOException {
        
        URL url = new URL(REGIOES_API_URL + id);

       
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       
        connection.setRequestMethod("GET");

       
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static String consultarEstados() throws IOException {
        
        URL url = new URL(ESTADOS_API_URL);

       
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        connection.setRequestMethod("GET");

        
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

       
        return response.toString();
    }


    
    public static String consultarDistritoIndentificador(int identificador) throws IOException {
       
        URL url = new URL(DISTRITOS_API_URL + identificador);

        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
       
        connection.setRequestMethod("GET");

       
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

      
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        
        return response.toString();
    }



}
