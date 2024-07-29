package com.InternShip.Backend.Model.Recepies;

import com.InternShip.Backend.Model.Users.user;

import jakarta.persistence.Entity;

@Entity
public class recepie {

  private user User;
  private String title;
  private String ingredients;
}
