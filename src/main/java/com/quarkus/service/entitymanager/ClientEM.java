package com.quarkus.service.entitymanager;

import com.quarkus.model.entity.ClientEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class ClientEM {
  
  @PersistenceContext
  EntityManager em;
  
  public void save(ClientEntity client) {
    em.persist(client);
  }
  
  public List<ClientEntity> list() {
    return em.createQuery("FROM Client", ClientEntity.class).getResultList();
  }
  
  public ClientEntity findById(Long id) {
    return em.find(ClientEntity.class, id);
  }
  
  public void deleteById(Long id) {
    ClientEntity p = em.find(ClientEntity.class, id);
    if (p != null) em.remove(p);
  }
  
}
