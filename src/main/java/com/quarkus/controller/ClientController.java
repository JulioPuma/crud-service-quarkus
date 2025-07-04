package com.quarkus.controller;


import com.quarkus.model.api.Client;
import com.quarkus.restclient.ClientThirdPartyRestClient;
import com.quarkus.service.ClientService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.Collection;
import java.util.Optional;

/**
 * Controller for managing clients.
 * This class provides endpoints to create, read, update, and delete clients.
 */
@Path("/clients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
public class ClientController {

  @Inject
  @RestClient
  ClientThirdPartyRestClient clientThirdPartyRestClient;
  
  @GET
  public Collection<Client> getAll() {
    log.info("Fetching all clients from third-party service");
    return clientThirdPartyRestClient.getAll();
  }
  
  @GET
  @Path("/{id}")
  public Response getById(@PathParam("id") long id) {
    return clientThirdPartyRestClient.getById(id);
  }
  
  @POST
  public Response create(Client client) {
    return clientThirdPartyRestClient.create(client);
  }
  
  @PUT
  public Response update(Client client) {
    return clientThirdPartyRestClient.update(client);
  }
  
  @DELETE
  @Path("/{id}")
  public Response delete(@PathParam("id") long id) {
    return clientThirdPartyRestClient.delete(id);
  }

}