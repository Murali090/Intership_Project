package com.InternShip.Backend.Repo;

import com.InternShip.Backend.Model.Users.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * UserRepo
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
