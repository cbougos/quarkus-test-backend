package com.example.model;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@MongoEntity(collection = "movie")
@NoArgsConstructor
@Setter
@Getter
public class Movie extends PanacheMongoEntity {
    private String title;
    private Integer year;
    private List<String> genres;
    private String rated;
    private List<String> languages;
    private LocalDateTime released;
    private Awards awards;
    private List<String> cast;
    private List<String> directors;
}
