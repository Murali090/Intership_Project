package com.InternShip.Backend.Model.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class user {

  @Id
  private Long userId;

  @NotEmpty
  private String FirstName;

  @NotEmpty
  private String LastName;

  @Email
  @NotEmpty
  private String email;

  public user(Long userId, @NotEmpty String firstName, @NotEmpty String lastName, @Email @NotEmpty String email) {
    this.userId = userId;
    FirstName = firstName;
    LastName = lastName;
    this.email = email;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return FirstName;
  }

  public void setFirstName(String firstName) {
    FirstName = firstName;
  }

  public String getLastName() {
    return LastName;
  }

  public void setLastName(String lastName) {
    LastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "user [userId=" + userId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email + "]";
  }

}
