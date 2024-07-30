package com.InternShip.Backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.InternShip.Backend.Model.Recepies.Recepies;

/**
 * RecepieRepo
 */
@Repository
public interface RecepieRepo extends JpaRepository<Recepies, Long> {

}
