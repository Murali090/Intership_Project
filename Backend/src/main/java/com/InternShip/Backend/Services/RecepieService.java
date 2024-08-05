package com.InternShip.Backend.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InternShip.Backend.Model.Recepies.Recepies;
import com.InternShip.Backend.Repo.RecepieRepo;

@Service
public class RecepieService {

  @Autowired
  private RecepieRepo rrepo;

  public List<Recepies> getRecepies() {
    return rrepo.findAll();
  }

  public String postRecepies(Recepies recepie) {

    rrepo.save(recepie);
    return "success";
  }

  public List<Recepies> findByname(Long id, String name) {
    return rrepo.findByName(id, name);
  }

}
