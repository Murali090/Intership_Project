package com.InternShip.Backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.InternShip.Backend.Model.Recepies.Recepies;
import com.InternShip.Backend.Model.Users.User;
import com.InternShip.Backend.Services.RecepieService;

import jakarta.validation.Valid;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * RecepieController
 */
@RestController
public class RecepieController {

  @Autowired
  private RecepieService rservice;

  @GetMapping("/users/{id}")
  public List<Recepies> getRecepies(@PathVariable int id) {
    return rservice.getRecepies();
  }

  @PostMapping("/recepie")
  public String Recepies(@Valid @RequestBody Recepies recepie) {
    rservice.postRecepies(recepie);
    return "Success";
  }
}
