package com.testing.service.panache.repository.resource;

import com.testing.model.entity.Cliente;
import com.testing.service.panache.repository.ClienteRepository;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheRepositoryResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(path = "clientes-repo")
public interface ClienteResource extends PanacheRepositoryResource<ClienteRepository, Cliente, Long> {
}