package cl.fespi.noticias.noticias.services;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import cl.fespi.noticias.noticias.entity.Noticia;
import cl.fespi.noticias.noticias.factory.GenericResponseFactory;
import cl.fespi.noticias.noticias.repository.INoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */
@Service
public class NoticiaServices implements INoticiaServices {

    @Autowired
    private INoticiaRepository noticiasRepository;

    @Autowired
    private GenericResponseFactory genericResponse;

    @Override
    public ResponseEntity<GenericResponse> listarNoticiasFavoritas() {
        return new ResponseEntity(genericResponse.buildResponse(noticiasRepository.findByIsFavorito(Boolean.TRUE)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> listarNoticiasFavoritasPorFecha() {
        return new ResponseEntity(genericResponse.buildResponse(noticiasRepository.findByIsFavoritoOrderByFechaPublicacionDesc(true)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> buscarNoticiaFavoritaPorTitulo(String titulo) {
        return new ResponseEntity(genericResponse.buildResponse(noticiasRepository.findByTitulo(titulo)), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenericResponse> guardarNoticiaFavorita(Noticia noticia) {
        noticia.setIdNoticia(null);
        noticiasRepository.save(noticia);
        return new ResponseEntity(genericResponse.buildResponse(null), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<GenericResponse> borrarNoticiaFavorita(Noticia noticia) {
        noticia.setIsFavorito(false);
        noticiasRepository.save(noticia);
        return new ResponseEntity(genericResponse.buildResponse(null), HttpStatus.ACCEPTED);
    }

}
