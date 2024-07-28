package com.InternShip.Backend.Services;

import com.InternShip.Backend.Repo.UserRepo;

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
}
