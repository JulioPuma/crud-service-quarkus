package com.quarkus.service;

import com.quarkus.config.ApplicationProperties;
import com.quarkus.model.entity.ClientEntity;
import com.quarkus.model.mapper.ClientMapper;
import com.quarkus.model.api.Client;
import com.quarkus.service.dao.ClientDaoService;
import com.quarkus.util.CRUDModeEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class ClientServiceImpl {
  
  @Inject
  ClientDaoService clientDaoService;
  
  @Inject
  ClientMapper clientMapper;
  
  @Inject
  ApplicationProperties properties;
  
  public List<Client> getAll() {
    var clientEntities =  clientDaoService.getAll(CRUDModeEnum.getModoCRUD(properties.getCrudMode()));
    return clientEntities.stream().map(clientMapper::toClient).toList();
  }
  
  public Response getById(@PathParam("id") long id) {
    var clientEntity= clientDaoService.getById(id, CRUDModeEnum.getModoCRUD(properties.getCrudMode()));
    if (clientEntity.isEmpty()) {
      return Response.status(Response.Status.NOT_FOUND).build();
    }
    return Response.ok(clientMapper.toClient(clientEntity.get())).build();
  }
  
  public Response create(Client client) {
    ClientEntity clientEntity = clientDaoService.create(clientMapper.toClientEntity(client), CRUDModeEnum.getModoCRUD(properties.getCrudMode()));
    Client response = clientMapper.toClient(clientEntity);
    return Response.status(Response.Status.CREATED).entity(response).build();
  }
  
  public Response update(Client client) {
    ClientEntity entity = clientDaoService.update(clientMapper.toClientEntity(client), CRUDModeEnum.getModoCRUD(properties.getCrudMode()));
    return Response.ok(entity).build();
  }
  
  public Response delete(@PathParam("id") long id) {
    clientDaoService.delete(id, CRUDModeEnum.getModoCRUD(properties.getCrudMode()));
    return Response.noContent().build();
  }
  
}
