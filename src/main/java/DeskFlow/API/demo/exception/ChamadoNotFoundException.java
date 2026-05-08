package DeskFlow.API.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChamadoNotFoundException extends RuntimeException {
    public ChamadoNotFoundException(Long id){
        super("Chamado com id " + id + " Não encontrado");
    }
}
