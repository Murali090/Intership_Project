package com.InternShip.Backend.Model.Users;

import java.util.List;

import com.InternShip.Backend.Model.Recepies.Recepies;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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

  enum GENDER {
    MALE, FEMALE;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @NotNull
  private String firstName;
  @NotNull
  private String lastName;

  private String password;

  @Email
  @NotEmpty
  private String email;

  @OneToMany(mappedBy = "users")
  @JsonIgnore
  private List<Recepies> recepie;

  @JsonProperty
  private GENDER gender;

  public User(Long userId, @NotEmpty String firstName, @NotEmpty String lastName, @NotNull String password,
      @Email @NotEmpty String email, List<Recepies> recepie, GENDER gender) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.email = email;
    this.recepie = recepie;
    this.gender = gender;
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

  @JsonIgnore
  public String getPassword() {
    return password;
  }

  @JsonProperty
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

  public GENDER getGender() {
    return gender;
  }

  public void setGender(GENDER gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
        + ", email=" + email + ", recepie=" + recepie + ", gender=" + gender + "]";
  }
}
