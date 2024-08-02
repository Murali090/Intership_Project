package com.InternShip.Backend.Services;

import com.InternShip.Backend.Model.Recepies.Recepies;
import com.InternShip.Backend.Model.Users.User;
import com.InternShip.Backend.Repo.UserRepo;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService {

  private UserRepo repo;

  public UserService(UserRepo repo) {
    this.repo = repo;
  }

  public void newuser(@Valid User user) {
    repo.save(user);
  }

  public List<User> getUsers() {
    return repo.findAll();
  }
}
