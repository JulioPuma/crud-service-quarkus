package com.quarkus.restclient;

import com.quarkus.model.api.Client;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;

@Path("/third-party")
@RegisterRestClient(configKey = "third-party-api")
public interface ClientThirdPartyRestClient {

    @GET
    List<Client> getAll();

    @GET
    @Path("/{id}")
    Response getById(long id);

    @POST
    Response create(Client client);

    @PUT
    Response update(Client client);

    @DELETE
    @Path("/{id}")
    Response delete(long id);
}
