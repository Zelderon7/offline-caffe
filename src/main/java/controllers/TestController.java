package controllers;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import models.DTOs.CreateTestRequest;
import models.Entities.TestEntity;
import services.TestService;

@Path("")
public class TestController {

    @Inject
    TestService testService;

    @Path("/test")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return "test";
    }

    @Path("/test-create")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TestEntity create(CreateTestRequest data) {
        return testService.createTestEntity(data.getName(), data.getEmail());
    }
}