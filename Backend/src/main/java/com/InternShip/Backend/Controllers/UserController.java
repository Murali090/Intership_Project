package com.InternShip.Backend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InternShip.Backend.Model.Users.User;
import com.InternShip.Backend.Services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
  private UserService service;

  public UserController(UserService service) {
    super();
    this.service = service;
  }

  @PostMapping("/register")
  public String register(@Valid @RequestBody User user) {
    service.newuser(user);
    return "Success";
  }
}
