package com.example.repository;

import com.example.model.Movie;
import io.quarkus.mongodb.panache.PanacheMongoRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieRepository implements PanacheMongoRepository<Movie> {
    public Movie findByTitle(String title) {
        return find("title", title).firstResult();
    }
}
