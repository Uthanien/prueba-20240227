package cl.fespi.noticias.noticias.factory;

import cl.fespi.noticias.noticias.domain.Notificacion;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

 /* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */

@Component
public class NotificacionResponseFactory {
    
    public List<Notificacion> buildNotificacionExito(){
        List<Notificacion> not = new ArrayList<>();
        not.add(Notificacion.builder()
            .code(HttpStatus.OK.toString())
            .message("Operación exitosa")
            .timeestamp(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME))
            .uuid(UUID.randomUUID().toString())
            .build());
        return not;
    }
    
    public List<Notificacion> buildNotificacionError(){
        return null;
    }
    
    public List<Notificacion> buildNotificacionCustom(){
        return null;
    }
    
}
