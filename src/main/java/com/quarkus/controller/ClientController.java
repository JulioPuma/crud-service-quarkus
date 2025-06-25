package com.quarkus.controller;


import com.quarkus.model.api.Client;
import com.quarkus.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Optional;

/**
 * Controller for managing clients.
 * This class provides endpoints to create, read, update, and delete clients.
 */
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {
  
  @Inject
  ClientService clientService;
  
  @GET
  public Collection<Client> getAll() {
    return clientService.getAll();
  }
  
  @GET
  @Path("/{id}")
  public Response getById(@PathParam("id") long id) {
    Optional<Client> optionalClient = clientService.getById(id);
    if (optionalClient.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(optionalClient.get()).build();
  }
  
  @POST
  public Response create(Client client) {
    Client clientCreated = clientService.create(client);
    return Response.status(Response.Status.CREATED)
      .entity(clientCreated).build();
  }
  
  @PUT
  public Response update(Client client) {
    return Response.ok(clientService.update(client)).build();
  }
  
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") long id) {
    clientService.delete(id);
    return Response.noContent().build();
  }

}