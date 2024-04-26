package org.estudos.br;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConsultaIBGEMockTest {
    
    @Mock
    private HttpURLConnection connectionMock;

    
    private static final String JSON_RESPONSE = "[{\"id\":520005005,\"nome\":\"Abadia de Goiás\",\"municipio\":{\"id\":5200050,\"nome\":\"Abadia de Goiás\",\"microrregiao\":{\"id\":52010,\"nome\":\"Goiânia\",\"mesorregiao\":{\"id\":5203,\"nome\":\"Centro Goiano\",\"UF\":{\"id\":52,\"sigla\":\"GO\",\"nome\":\"Goiás\",\"regiao\":{\"id\":5,\"sigla\":\"CO\",\"nome\":\"Centro-Oeste\"}}}},\"regiao-imediata\":{\"id\":520001,\"nome\":\"Goiânia\",\"regiao-intermediaria\":{\"id\":5201,\"nome\":\"Goiânia\",\"UF\":{\"id\":52,\"sigla\":\"GO\",\"nome\":\"Goiás\",\"regiao\":{\"id\":5,\"sigla\":\"CO\",\"nome\":\"Centro-Oeste\"}}}}}}]"; 
    @BeforeEach
    public void setup() throws IOException {
        
        MockitoAnnotations.openMocks(this);

        
        InputStream inputStream = new ByteArrayInputStream(JSON_RESPONSE.getBytes());
        when(connectionMock.getInputStream()).thenReturn(inputStream);
    }

    
    @Test
    @DisplayName("Consulta usando o Mock")
    public void testConsultarDistritoIdentificadorComMock() throws IOException {
        
        int identificadorDistrito = 520005005;

       
        String response = ConsultaIBGE.consultarDistritoIndentificador(identificadorDistrito);

        
        assertEquals(JSON_RESPONSE, response, "O JSON retornado não corresponde ao esperado.");
    }
}
