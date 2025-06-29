package com.quarkus.service.repository;

import com.quarkus.model.entity.ClientEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<ClientEntity> {
}
