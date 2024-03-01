package cl.fespi.noticias.noticias.domain;

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
public class Notificacion {
    private String code;
    private String message;
    private String uuid;
    private String timeestamp;
    private Object metadata;      
}
