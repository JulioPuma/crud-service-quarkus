package com.quarkus.model.mapper;

import com.quarkus.model.api.Client;
import com.quarkus.model.entity.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface ClientMapper {
  
  ClientEntity toClientEntity (Client client);
  Client toClient (ClientEntity clientEntity);
}
