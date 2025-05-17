package com.testing.service.restclient;

import com.testing.model.entity.Cliente;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.List;

/**
 * To use it via injection.
 *
 * {@code
 *     @Inject
 *     @RestClient
 *     MyRemoteService myRemoteService;
 *
 *     public void doSomething() {
 *         Set<MyRemoteService.Extension> restClientExtensions = myRemoteService.getExtensionsById("io.quarkus:quarkus-hibernate-validator");
 *     }
 * }
 */
@RegisterRestClient(baseUri = "https://localhost:9091")
public interface ClienteRestClient {

    @GET
    @Path("third-party/clients")
    List<Cliente> getClientFromRest();

}
