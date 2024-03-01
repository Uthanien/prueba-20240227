package cl.fespi.noticias.noticias.controller;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import cl.fespi.noticias.noticias.services.INoticiaServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
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
    @Operation(summary = "Listado de noticias favoritas", 
            description = "Metodo que retorna el listado de noticias favoritas.")
    @GetMapping(value = "/favoritos", 
            produces = { "application/json" })
    public ResponseEntity<GenericResponse> listarNoticiasFavoritas(){
        log.info("Llamada GET /api/v1/favoritos");
        return registroService.listarNoticiasFavoritas();
    }
    
}
