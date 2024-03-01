package cl.fespi.noticias.noticias.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

 /* 
 * 
 * @version     1.0.0 27-02-2024
 * @author      Felipe Espinosa C.
 * @since       1.0.0 27-02-2024
 * 
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse {
    private Object data;
    private List<Notificacion> notifications;     
}
