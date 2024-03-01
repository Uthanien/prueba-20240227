package cl.fespi.noticias.noticias.repository;

import cl.fespi.noticias.noticias.entity.Noticia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 /* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */

@Repository
public interface INoticiaRepository extends JpaRepository<Noticia, Long> {
    public List<Noticia> findByIsFavorito(Boolean isFavorito);
    public Noticia findByTitulo(String titulo);
    public List<Noticia> findByIsFavoritoOrderByFechaPublicacionDesc(Boolean isFavorito);
}
