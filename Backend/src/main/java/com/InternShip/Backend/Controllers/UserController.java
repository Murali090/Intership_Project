package com.InternShip.Backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InternShip.Backend.Services.UserService;

@RestController
public class UserController {
  private UserService service;

  public UserController(UserService service) {
    super();
    this.service=service;
  }

  @GetMapping("/users")
  public void getusers(){
    service.getUsers();
  }
}
