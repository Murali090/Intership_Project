package com.InternShip.Backend.Exceptions.Details;

/**
 * ErrorDetails
 */

public class ErrorDetails {

  private String message;
  private String details;

  public ErrorDetails(String message, String details) {
    this.message = message;
    this.details = details;
  }

  public String getMessage() {
    return message;
  }

  public String getDetails() {
    return details;
  }

}
