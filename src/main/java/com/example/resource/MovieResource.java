package com.example.resource;

import com.example.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieResource {
    private final MovieService movieService;

    @GET
    @Path("/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByTitle(@PathParam("title") String title) {
        log.info("Log from movies - getByTitle resource!");
        return Response.ok(movieService.findByTitle(title)).build();
    }

    @GET
    @Path("/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCount() {
        log.info("Log from movies - getCount resource!");
        return Response.ok(movieService.count()).build();
    }
}
