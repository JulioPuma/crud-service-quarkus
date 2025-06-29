package com.quarkus.service.dao;

import com.quarkus.model.entity.ClientEntity;
import com.quarkus.service.entitymanager.ClientEM;
import com.quarkus.service.repository.ClientRepository;
import com.quarkus.util.CRUDModeEnum;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ClientDaoService {
  
  @Inject
  ClientRepository clientRepository;
  
  @Inject
  ClientEM clientEM;
  
  @Transactional
  public ClientEntity create(ClientEntity client, CRUDModeEnum modo) {
    switch (modo) {
      case PANACHE_ENTITY -> client.persist();
      case PANACHE_REPOSITORY -> clientRepository.persist(client);
      case ENTITY_MANAGER -> clientEM.save(client);
    };
    return client;
  }
  
  @Transactional
  public List<ClientEntity> getAll(CRUDModeEnum modo) {
    return switch (modo) {
      case PANACHE_ENTITY -> ClientEntity.listAll();
      case PANACHE_REPOSITORY -> clientRepository.listAll();
      case ENTITY_MANAGER -> clientEM.list();
    };
  }
  
  @Transactional
  public Optional<ClientEntity> getById(Long id, CRUDModeEnum modo) {
    return switch (modo) {
      case PANACHE_ENTITY -> ClientEntity.findByIdOptional(id);
      case PANACHE_REPOSITORY -> clientRepository.findByIdOptional(id);
      case ENTITY_MANAGER -> Optional.ofNullable(clientEM.findById(id));
    };
  }
  
  @Transactional
  public void delete(Long id, CRUDModeEnum modo) {
    switch (modo) {
      case PANACHE_ENTITY -> ClientEntity.deleteById(id);
      case PANACHE_REPOSITORY -> clientRepository.deleteById(id);
      case ENTITY_MANAGER -> clientEM.deleteById(id);
    };
  }
  
  @Transactional
  public ClientEntity update(ClientEntity client, CRUDModeEnum modo) {
    return switch (modo) {
      case PANACHE_ENTITY -> modify(client, CRUDModeEnum.PANACHE_ENTITY);
      case PANACHE_REPOSITORY -> modify(client, CRUDModeEnum.PANACHE_REPOSITORY);
      case ENTITY_MANAGER -> modify(client, CRUDModeEnum.ENTITY_MANAGER);
    };
  }
  
  public ClientEntity modify(ClientEntity clientEntityModify, CRUDModeEnum modo) {
    Optional<ClientEntity> entity = getById(clientEntityModify.getId(), modo);
    entity.ifPresent(client -> {
      entity.get().setEmail(clientEntityModify.getEmail());
      entity.get().setName(clientEntityModify.getName());
    });
    return entity.get();
  }
}
