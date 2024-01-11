package com.paranoidal97.ProductstMicroservice.exception.handler;

import com.paranoidal97.ProductstMicroservice.exception.*;
import com.paranoidal97.ProductstMicroservice.model.dto.MessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@ControllerAdvice
public class OrderExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<MessageDto> handleDataNotFoundException(DataNotFoundException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new MessageDto(ex.getMessage(), ex.getStatus(), LocalDateTime.now()));
    }

    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity<MessageDto> handleDataAlreadyExsistException(DataNotFoundException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new MessageDto(ex.getMessage(), ex.getStatus(), LocalDateTime.now()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<MessageDto> handleBadRequestException(BadRequestException ex) {
        return ResponseEntity.status(ex.getStatus()).body(new MessageDto(ex.getMessage(), ex.getStatus(), LocalDateTime.now()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<MessageDto> handleRuntimeException(RuntimeException ex) {
        String defaultMessage = "Error in aplication";
        MessageDto messageDto = new MessageDto(defaultMessage, HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now().toLocalDateTime());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messageDto);
    }
}
