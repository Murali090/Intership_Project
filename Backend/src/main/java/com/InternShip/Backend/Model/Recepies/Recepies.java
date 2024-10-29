package com.InternShip.Backend.Model.Recepies;

import com.InternShip.Backend.Model.Users.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Recepies {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @JsonIgnore
  private Long recepieId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JsonIgnore
  private User users;

  @NotNull
  private String title;

  @NotNull
  @Size(min = 1)
  private String ingredients;

  @NotNull
  @Size(min = 1)
  private String instructions;

  public Recepies() {
  }

  public Recepies(@NotNull Long recepieId, User users, @NotNull String title,
      @NotNull @Size(min = 5) String ingredients,
      @NotNull @Size(min = 5) String instructions) {
    this.recepieId = recepieId;
    this.users = users;
    this.title = title;
    this.ingredients = ingredients;
    this.instructions = instructions;
  }

  public Long getRecepieId() {
    return recepieId;
  }

  public void setRecepieId(Long recepieId) {
    this.recepieId = recepieId;
  }

  public User getUsers() {
    return users;
  }

  public void setUsers(User users) {
    this.users = users;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  @Override
  public String toString() {
    return "recepies [recepieId=" + recepieId + ", users=" + users + ", title=" + title + ", ingredients=" + ingredients
        + ", instructions=" + instructions + "]";
  }

}
