package spring.academy.springboot1.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spring.academy.springboot1.exception.BadRequestExceptionDetails;
import spring.academy.springboot1.exception.BadRequestException;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bedRequestException){
        return new ResponseEntity<>(
                BadRequestExceptionDetails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Requestion Exeption, Please Check de Documentation!")
                        .details(bedRequestException.getMessage())
                        .developerMessage(bedRequestException.getClass().getName())
                        .build(), HttpStatus.BAD_REQUEST
                );
    }
}
