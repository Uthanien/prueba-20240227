package cl.fespi.noticias.noticias.services;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import cl.fespi.noticias.noticias.entity.Noticia;
import java.util.Date;
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

    @DisplayName("Pruebas para metodo listado de noticias favoritas")
    @Test
    void listarNoticiasFavoritasTest() {
        System.out.println("TEST - listarNoticiasFavoritasTest");        
        
        ResponseEntity<GenericResponse> salida = noticia.listarNoticiasFavoritas();
        Assertions.assertNotNull(salida.getBody().getData());
        Assertions.assertNotNull(salida.getBody().getNotifications());
        Assertions.assertEquals(200, salida.getStatusCode().value());
    }
    
    @DisplayName("Pruebas para metodo listado de noticias favoritas ordenada por fechas")
    @Test
    void listarNoticiasFavoritasPorFechaTest() {
        System.out.println("TEST - listarNoticiasFavoritasPorFechaTest");        
        
        ResponseEntity<GenericResponse> salida = noticia.listarNoticiasFavoritasPorFecha();
        Assertions.assertNotNull(salida.getBody().getData());
        Assertions.assertNotNull(salida.getBody().getNotifications());
        Assertions.assertEquals(200, salida.getStatusCode().value());
    }
    
    @DisplayName("Pruebas para metodo buscar noticia favorita por titulo")
    @Test
    void buscarNoticiaFavoritaPorTituloTest() {
        System.out.println("TEST - buscarNoticiaFavoritaPorTituloTest");        
        
        ResponseEntity<GenericResponse> salida = noticia.buscarNoticiaFavoritaPorTitulo("titulo 1");
        Assertions.assertNotNull(salida.getBody().getData());
        Assertions.assertNotNull(salida.getBody().getNotifications());
        Assertions.assertEquals(200, salida.getStatusCode().value());
        
        ResponseEntity<GenericResponse> salidaDos = noticia.buscarNoticiaFavoritaPorTitulo("Titulo 1");
        Assertions.assertNull(salidaDos.getBody().getData());
        Assertions.assertNotNull(salidaDos.getBody().getNotifications());
        Assertions.assertEquals(200, salidaDos.getStatusCode().value());
    }
    
    @DisplayName("Pruebas para metodo guardar noticia favorita")
    @Test
    void guardarNoticiaFavoritaTest() {
        System.out.println("TEST - guardarNoticiaFavoritaTest");        
        
        Noticia not = new Noticia();
        not.setTitulo("Titulo TEST");
        not.setDescripcion("Descripcion TEST");
        not.setResumen("Resumen TEST");
        not.setFechaPublicacion(new Date());
        not.setIsFavorito(true);
        
        ResponseEntity<GenericResponse> salida = noticia.guardarNoticiaFavorita(not);
        Assertions.assertNull(salida.getBody().getData());
        Assertions.assertNotNull(salida.getBody().getNotifications());
        Assertions.assertEquals(201, salida.getStatusCode().value());
    }
    
    @DisplayName("Pruebas para metodo borrar noticia favorita")
    @Test
    void borrarNoticiaFavoritaTest() {
        System.out.println("TEST - borrarNoticiaFavoritaTest");        
    
        ResponseEntity<GenericResponse> salida = noticia.borrarNoticiaFavorita(1L);
        Assertions.assertNull(salida.getBody().getData());
        Assertions.assertNotNull(salida.getBody().getNotifications());
        Assertions.assertEquals(202, salida.getStatusCode().value());
    }
}
