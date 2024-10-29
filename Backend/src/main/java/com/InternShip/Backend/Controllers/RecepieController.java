package com.InternShip.Backend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.InternShip.Backend.Exceptions.userNotFoundException;
import com.InternShip.Backend.Model.Recepies.Recepies;
import com.InternShip.Backend.Repo.RecepieRepo;
import com.InternShip.Backend.Services.RecepieService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

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

  @GetMapping("/user/{id}/recepies/{name}")
  public ResponseEntity<List<Recepies>> getByName(@PathVariable Long id, @PathVariable String name) {
    List<Recepies> rece = rservice.findByname(id, name);

    if (rece.isEmpty()) {
      throw new userNotFoundException("Not Found " + id);
    }

    return ResponseEntity.ok(rece);
  }
}
