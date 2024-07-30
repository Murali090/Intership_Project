package com.InternShip.Backend.Model.Recepies;

import com.InternShip.Backend.Model.Users.user;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class recepies {

  @ManyToOne()
  private user users;

  @NotNull
  private String title;

  @NotNull
  @Size(min = 5, max = 15, message = "Not enought characters")
  private String ingredients;

  @NotNull
  @Size(min = 5, max = 20, message = "Not enought word")
  private String instructions;

  public recepies() {
  }

  public recepies(user users, @NotNull String title,
      @NotNull @Size(min = 5, max = 15, message = "Not enought characters") String ingredients,
      @NotNull @Size(min = 5, max = 20, message = "Not enought word") String instructions) {
    this.users = users;
    this.title = title;
    this.ingredients = ingredients;
    this.instructions = instructions;
  }

  public user getUsers() {
    return users;
  }

  public void setUsers(user users) {
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
    return "recepies [users=" + users + ", title=" + title + ", ingredients=" + ingredients + ", instructions="
        + instructions + "]";
  }
}
