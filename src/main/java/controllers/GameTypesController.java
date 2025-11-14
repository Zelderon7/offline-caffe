package controllers;

import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.Entities.GameTypes;
import org.jboss.resteasy.annotations.Body;
import services.GameTypesService;

import java.util.Map;
import java.util.Optional;

@Path("/games")
public class GameTypesController {
    @Inject
    GameTypesService service;

    @POST
    @Transactional
    @Path("/create-type")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createGameType(final GameTypes gameType) {
        gameType.id = null;
        try{
            GameTypes result = service.create(gameType);
            return Response
                    .status(201)
                    .entity(result)
                    .build();
        }catch(PersistenceException e){
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(Map.of("error", "Game type already exists!"))
                    .build();
        }catch (Exception e) {
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(Map.of("error", "Failed to create entity"))
                    .build();
        }
    }
}
