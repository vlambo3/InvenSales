package com.elaparato.exception;

import com.elaparato.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> ExceptionHandler(NotFoundException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException e){

        // Extrae los mensajes de error de validación de los errores de campo obtenidos de la excepción.
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getBindingResult().getFieldErrors().stream()

                // Mapea los mensajes de error de campo a sus mensajes predeterminados.
                .map(DefaultMessageSourceResolvable::getDefaultMessage)

                // Filtra los mensajes de error que no son nulos.
                .filter(Objects::nonNull)

                // Obtiene el primer mensaje de error encontrado. Si no se encuentra ninguno, devuelve un mensaje de error genérico.
                .findFirst()
                .orElse("Validation failed"));

        // Devuelve un ResponseEntity que contiene un objeto ExceptionDTO con el mensaje de error obtenido de la validación,
        // junto con un estado HTTP 400 (BAD REQUEST).
        return new ResponseEntity<>(exceptionDto,HttpStatus.BAD_REQUEST);
    }*/


}
