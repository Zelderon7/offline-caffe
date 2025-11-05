package controllers;


import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.DTOs.CreateTestRequest;
import models.Entities.TestEntity;
import services.TestService;

import java.net.URI;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestController {

    @Inject
    TestService testService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "Hello, world";
    }

    @GET
    @Path("/{id}")
    public TestEntity getTest(@PathParam("id") Long id) {
        return TestEntity.findById(id);
    }

    @POST
    @Path("/create")
    @Transactional
    public Response create(CreateTestRequest data) {
        Long id = testService.createTestEntity(data);
        return Response.created(URI.create("/test/" + id)).build();
    }
}