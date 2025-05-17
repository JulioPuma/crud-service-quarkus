package com.testing.controller;

import com.testing.model.entity.Cliente;
import com.testing.service.panache.repository.ClienteRepository;
import com.testing.service.restclient.ClienteRestClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@Path("/clientes/busqueda")
public class ClienteController {
  
  @Inject
  ClienteRepository clienteRepository;

  @Inject
  @RestClient
  ClienteRestClient clienteRestClient;

  @GET
  @Path("/rest")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Cliente> listFromThirdparty() {
    return clienteRestClient.getClientFromRest();
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Cliente> list() {
    return clienteRepository.listAll();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Cliente getClienteById(@PathParam("id") Long id) {
    return clienteRepository.findById(id);
  }

  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void save(Cliente cliente) {
    clienteRepository.persist(cliente);
  }

  @PATCH
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public void update(@PathParam("id") Long id, Cliente cliente) {
    Cliente clienteFromDB = clienteRepository.findById(id);
    clienteFromDB.setCorreo(cliente.getCorreo());
    clienteFromDB.setNombre(cliente.getNombre());
    clienteRepository.persist(clienteFromDB);
  }


}