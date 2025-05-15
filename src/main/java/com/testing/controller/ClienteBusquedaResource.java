package com.testing.controller;

import com.testing.model.entity.Cliente;
import com.testing.service.panache.repository.ClienteRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

/**
 * Al exponer este controllador, se expone no solo:
 * </br> GET /clientes/busqueda/{nombre}
 * </br> sino tambien observaremos el CRUD completo para:
 * </br> /clientes
 * a causa de la interfaz ClienteResource.java
 */
@Path("/clientes/busqueda")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClienteBusquedaResource {
  
  @Inject
  ClienteRepository clienteRepository;
  
  @GET
  @Path("/{nombre}")
  public List<Cliente> buscarPorNombre(@PathParam("nombre") String nombre) {
    return clienteRepository.buscarPorNombre(nombre);
  }
}