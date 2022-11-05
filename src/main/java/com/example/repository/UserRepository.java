package com.example.repository;

import com.example.model.User;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository implements ReactivePanacheMongoRepository<User> {
}
