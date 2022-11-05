package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import io.quarkus.logging.Log;
import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public Multi<User> streamAll() {
        return userRepository.streamAll().onItem().invoke(item -> {
            try {
                Thread.sleep(500);
                log.info("Retrieved user: {}", item);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
