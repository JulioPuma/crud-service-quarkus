package com.quarkus.controller;

import com.quarkus.model.api.Client;
import com.quarkus.service.ClientServiceImpl;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

/**
 * Controller for managing clients.
 * This class provides endpoints to create, read, update, and delete clients.
 */
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientController {
  
  @Inject
  ClientServiceImpl clientService;
  
  @GET
  public List<Client> getAll() {
    return clientService.getAll();
  }
  
  @GET
  @Path("/{id}")
  public Response getById(@PathParam("id") long id) {
    return clientService.getById(id);
  }
  
  @POST
  public Response create(Client client) {
    return clientService.create(client);
  }
  
  @PUT
  public Response update(Client client) {
    return clientService.update(client);
  }
  
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") long id) {
    return clientService.delete(id);
  }

}