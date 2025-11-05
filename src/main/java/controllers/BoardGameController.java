package controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import services.BoardGamesService;

@Path("/games")
public class BoardGameController {

    @Inject
    BoardGamesService service;

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer count(){
        return service.getCount();
    }
}
