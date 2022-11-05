package com.example.resource;

import com.example.model.User;
import com.example.service.UserService;
import io.smallrye.mutiny.Multi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Slf4j
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @GET
    @Path("/stream/all")
    public Multi<User> streamAll() {
        log.info("Log from users - streamAll resource!");
        return userService.streamAll();
    }
}
