package DeskFlow.API.demo.exception;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
@RestControllerAdvice

public class GlobalExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String tratarErro(RuntimeException ex) {
            return ex.getMessage();
        }
    }
