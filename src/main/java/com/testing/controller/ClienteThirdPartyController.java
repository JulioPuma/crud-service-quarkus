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
@Path("/third-party/clients")
public class ClienteThirdPartyController {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Cliente> list() {
    Cliente cliente1 = new Cliente();
    cliente1.setId(101L);
    cliente1.setNombre("Julio");
    cliente1.setCorreo("julio@gmail.com");

    Cliente cliente2 = new Cliente();
    cliente2.setId(102L);
    cliente2.setNombre("Cesar");
    cliente2.setCorreo("cesar@gmail.com");

    Cliente cliente3 = new Cliente();
    cliente3.setId(103L);
    cliente3.setNombre("Ricardo");
    cliente3.setCorreo("ricardo@gmail.com");

    return List.of(cliente1, cliente2, cliente3);
  }


}