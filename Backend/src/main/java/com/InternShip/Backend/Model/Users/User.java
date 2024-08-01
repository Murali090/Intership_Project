package com.InternShip.Backend.Model.Users;

import java.util.List;

import com.InternShip.Backend.Model.Recepies.Recepies;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NotEmpty
  private String firstName;

  @NotEmpty
  private String lastName;

  @NotNull
  @JsonIgnore
  private String password;

  @Email
  @NotEmpty
  private String email;

  @OneToMany(mappedBy = "users")
  private List<Recepies> recepie;

  public User(Long userId, @NotEmpty String firstName, @NotEmpty String lastName, @NotNull String password,
      @Email @NotEmpty String email, List<Recepies> recepie) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.recepie = recepie;
  }

  public User() {
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Recepies> getRecepie() {
    return recepie;
  }

  public void setRecepie(List<Recepies> recepie) {
    this.recepie = recepie;
  }

  @Override
  public String toString() {
    return "user [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
        + ", email=" + email + ", recepie=" + recepie + "]";
  }
}
