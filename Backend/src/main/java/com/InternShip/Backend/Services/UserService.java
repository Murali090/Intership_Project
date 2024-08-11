package com.InternShip.Backend.Services;

import com.InternShip.Backend.Model.Users.User;
import com.InternShip.Backend.Repo.UserRepo;
import com.InternShip.Backend.Security.SecurityConfig;
import com.InternShip.Backend.Security.UserPrincipals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * UserService
 */
@Service
public class UserService implements UserDetailsService {

  private UserRepo repo;

  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public UserService(UserRepo repo) {
    this.repo = repo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = (User) repo.findByFirstName(username);

    if (user == null) {
      throw new UsernameNotFoundException("UserName not Found");
    }

    return new UserPrincipals(user);
  }

  public User newuser(User user) {
    user.setPassword(encoder.encode(user.getPassword()));
    return repo.save(user);
  }

  public List<User> getUsers() {
    return repo.findAll();
  }

}
