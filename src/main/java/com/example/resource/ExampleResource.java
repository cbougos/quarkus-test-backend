package com.example.resource;

import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
@Slf4j
public class ExampleResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response hello() {
        log.info("Log from hello resource!");
        return Response.ok("Hello from RESTEasy Reactive!").build();
    }
}
