package com.InternShip.Backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AiExceptions
 */
@ResponseStatus(code = HttpStatus.NO_CONTENT)
public class AiExceptions extends RuntimeException {
  public AiExceptions(String message) {
    super(message);
  }
}
