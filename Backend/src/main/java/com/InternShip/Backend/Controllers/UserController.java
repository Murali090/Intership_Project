package com.InternShip.Backend.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InternShip.Backend.Model.Recepies.Recepies;
import com.InternShip.Backend.Model.Users.User;
import com.InternShip.Backend.Repo.RecepieRepo;
import com.InternShip.Backend.Repo.UserRepo;
import com.InternShip.Backend.Services.UserService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/users")
public class UserController {

  private UserService service;

  private UserRepo repo;

  private RecepieRepo recepierepo;

  public UserController(UserService service, RecepieRepo recepierepo, UserRepo repo) {
    super();
    this.service = service;
    this.recepierepo = recepierepo;
    this.repo = repo;
  }

  @PostMapping("/registerUser")
  public String register(@Valid @RequestBody User user) {
    service.newuser(user);
    return "Success";
  }

  @GetMapping("/user")
  public List<User> getusers() {
    return service.getUsers();
  }

  @PostMapping("/registerUserRecepie/{id}/recepies")
  public String register(@PathVariable Long id, @Valid @RequestBody Recepies recepie) {
    Optional<User> user = repo.findById(id);

    recepie.setUsers(user.get());

    recepierepo.save(recepie);

    return "Success";
  }

  @GetMapping("/getUserRecepie/{id}/recepies")
  public List<Recepies> getRecepies(@PathVariable Long id) {

    Optional<User> user = repo.findById(id);

    return user.get().getRecepie();
  }
}
