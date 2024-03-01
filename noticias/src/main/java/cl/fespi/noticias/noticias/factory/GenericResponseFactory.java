package cl.fespi.noticias.noticias.factory;

import cl.fespi.noticias.noticias.domain.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

 /* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */

@Component
public class GenericResponseFactory {
    
    @Autowired
    private NotificacionResponseFactory notificacion;
    
    public GenericResponse buildResponse(Object response){
        return GenericResponse.builder()
                .data(response)
                .notifications(notificacion.buildNotificacionExito())
                .build();        
    }
    
}
