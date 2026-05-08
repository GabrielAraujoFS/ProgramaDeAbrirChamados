package DeskFlow.API.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ChamadoNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> tratarNaoEncontrado(ChamadoNotFoundException ex) {
        return Map.of("erro", ex.getMessage());
    }

    @ExceptionHandler(ChamadoBussinesException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> tratarNegocio(ChamadoBussinesException ex) {
        return Map.of("erro", ex.getMessage());
    }

    // RuntimeException genérica vira 500 agora — correto!
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> tratarErroInesperado(RuntimeException ex) {
        return Map.of("erro", "Erro interno inesperado");
    }
}