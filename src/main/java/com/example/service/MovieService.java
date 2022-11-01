package com.example.service;

import com.example.model.Movie;
import com.example.repository.MovieRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public Movie findByTitle(String title) {
        return movieRepository.findByTitle(title);
    }

    public Long count() {
        return movieRepository.count();
    }
}
