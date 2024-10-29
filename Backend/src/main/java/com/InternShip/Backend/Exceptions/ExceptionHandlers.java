package com.InternShip.Backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.InternShip.Backend.Exceptions.Details.ErrorDetails;

/**
 * ExceptionHandlers
 */
@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
    ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(userNotFoundException.class)
  public final ResponseEntity<ErrorDetails> handleNotFoundException(Exception ex, WebRequest request) throws Exception {
    ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(wrongOperation.class)
  public final ResponseEntity<ErrorDetails> handleBadException(Exception ex, WebRequest request) throws Exception {
    ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(AiExceptions.class)
  public final ResponseEntity<ErrorDetails> handleAiException(Exception ex, WebRequest request) throws Exception {
    ErrorDetails error = new ErrorDetails(ex.getMessage(), request.getDescription(false));
    return new ResponseEntity<ErrorDetails>(error, HttpStatus.NO_CONTENT);
  }
}
