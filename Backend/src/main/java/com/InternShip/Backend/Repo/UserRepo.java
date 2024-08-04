package com.InternShip.Backend.Repo;

import com.InternShip.Backend.Model.Users.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * UserRepo
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

  @Query("SELECT r.title,r.ingredients,r.instructions  from Recepies r where r.users=?1 and r.title=?2")
  Optional<User> findByName(Long id, String name);
}
