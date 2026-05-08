package DeskFlow.API.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ChamadoBussinesException extends RuntimeException{
    public ChamadoBussinesException(String mensagem){
        super(mensagem);
    }
}
