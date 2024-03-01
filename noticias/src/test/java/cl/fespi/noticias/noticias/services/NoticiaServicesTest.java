package cl.fespi.noticias.noticias.services;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

/* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */
@SpringBootTest
public class NoticiaServicesTest {
    
    @Autowired
    private INoticiaServices noticia;  

    @DisplayName("Comprobar que el listado de noticias favoritas trae datos")
    @Test
    void listarNoticiasFavoritas() {
        System.out.println("TEST - listarNoticiasFavoritas");        
        
        ResponseEntity<GenericResponse> salida = noticia.listarNoticiasFavoritas();
        Assertions.assertNotNull(salida.getBody());
        Assertions.assertEquals(200, salida.getStatusCode().value());
        
        System.out.println("TEST - listarNoticiasFavoritas");  
    }

}
