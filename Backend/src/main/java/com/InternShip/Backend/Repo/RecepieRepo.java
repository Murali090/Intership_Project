package com.InternShip.Backend.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.InternShip.Backend.Model.Recepies.Recepies;

@Repository
public interface RecepieRepo extends JpaRepository<Recepies, Long> {
  @Query("SELECT r  from Recepies r where r.users.userId = :user_id and r.title=:title")
  List<Recepies> findByName(@Param("user_id") Long id, @Param("title") String name);
}
