package cl.fespi.noticias.noticias.controller;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import cl.fespi.noticias.noticias.entity.Noticia;
import cl.fespi.noticias.noticias.services.INoticiaServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

 /* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */

@Tag(name = "noticias-controller-v1", description = "Controlador de Noticias v1")
@Slf4j
@RestController
@RequestMapping("/api/v1")
public class NoticiasController {
    
    @Autowired
    private INoticiaServices registroService;  
    
    /**
     * Metodo que retorna el listado de noticias favoritas
     * 
     * @return 
     */
    @Operation(summary = "Listado de noticias favoritas.", 
            description = "Metodo que retorna el listado de noticias favoritas.")
    @GetMapping(value = "/favoritos", 
            produces = { "application/json" })
    public ResponseEntity<GenericResponse> listarNoticiasFavoritas(){
        log.info("Llamada GET /api/v1/favoritos");
        return registroService.listarNoticiasFavoritas();
    }
    
    /**
     * Metodo que agrega una nueva noticia favorita 
     * 
     * @param noticia
     * @return 
     */
    @Operation(summary = "Agrega nueva noticia favorita.", description = "Metodo que agrega una noticia favorita.")
    @PostMapping(value = "/favorito", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<GenericResponse> agregaNoticiaFavorita(@RequestBody Noticia noticia){
        log.info("Llamada POST /api/v1/favorito");
        return registroService.guardarNoticiaFavorita(noticia);
    }
    
    /**
     * Metodo que borra una noticia favorita
     * 
     * @param noticia
     * @return 
     */
    @Operation(summary = "Borra noticia favorita.", description = "Metodo que borra una noticia favorita.")
    @DeleteMapping(value = "/favorito", produces = { "application/json" }, consumes = { "application/json" })
    public ResponseEntity<GenericResponse> borrarNoticiaFavorita(@RequestBody Noticia noticia){
        log.info("Llamada DELETE /api/v1/favorito");
        return registroService.borrarNoticiaFavorita(noticia);
    }
}
