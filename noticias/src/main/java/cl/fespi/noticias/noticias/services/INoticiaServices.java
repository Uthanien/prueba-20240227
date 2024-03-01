
package cl.fespi.noticias.noticias.services;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import cl.fespi.noticias.noticias.entity.Noticia;
import org.springframework.http.ResponseEntity;
 /* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */

public interface INoticiaServices {
    public ResponseEntity<GenericResponse> listarNoticiasFavoritas();
    public ResponseEntity<GenericResponse> listarNoticiasFavoritasPorFecha();
    public ResponseEntity<GenericResponse> buscarNoticiaFavoritaPorTitulo(String titulo);
    public ResponseEntity<GenericResponse> guardarNoticiaFavorita(Noticia noticia);
    public ResponseEntity<GenericResponse> borrarNoticiaFavorita(Long id);
    
    
}
