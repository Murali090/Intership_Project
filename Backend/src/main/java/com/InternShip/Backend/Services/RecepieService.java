package com.InternShip.Backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InternShip.Backend.Repo.RecepieRepo;

@Service
public class RecepieService {

  @Autowired
  private RecepieRepo rrepo;

}
