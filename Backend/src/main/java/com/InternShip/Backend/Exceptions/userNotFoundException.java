package com.InternShip.Backend.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * userNotFoundException
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class userNotFoundException extends RuntimeException {
  public userNotFoundException(String message) {
    super(message);
  }
}
