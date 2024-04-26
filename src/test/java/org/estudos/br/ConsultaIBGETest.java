package org.estudos.br;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultaIBGETest {
    private static final String REGIOES_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/regioes/";
    private static final String ESTADOS_API_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/";

    @Test
    @DisplayName("Teste para consulta única de uma região")
    public void testConsultarRegiao() throws IOException {
       
        int id = 1; 

        String resposta = ConsultaIBGE.consultarRegiao(id); 
        
        assert !resposta.isEmpty();
        
        HttpURLConnection connection = (HttpURLConnection) new URL(REGIOES_API_URL + id).openConnection();
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode, "O status code da resposta da API deve ser 200 (OK)");
    }

    
    @Test
    @DisplayName("Teste para consultar todos os estados")
    public void testConsultarEstados() throws IOException {

       
        String resposta = ConsultaIBGE.consultarEstados(); 

       
        assert !resposta.isEmpty();

       
        HttpURLConnection connection = (HttpURLConnection) new URL(ESTADOS_API_URL).openConnection();
        int statusCode = connection.getResponseCode();
        assertEquals(200, statusCode, "O status code da resposta da API deve ser 200 (OK)");
    }

}