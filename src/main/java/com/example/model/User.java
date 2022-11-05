package com.example.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.reactive.ReactivePanacheMongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.bson.codecs.pojo.annotations.BsonProperty;

@MongoEntity(collection = "user")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User extends ReactivePanacheMongoEntity {
    private String email;
    private String username;
    @BsonProperty(value = "first_name")
    private String firstName;
    @BsonProperty(value = "last_name")
    private String lastName;
}
