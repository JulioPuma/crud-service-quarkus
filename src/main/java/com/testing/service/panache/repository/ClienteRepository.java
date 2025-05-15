package com.testing.service.panache.repository;

import com.testing.model.entity.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {
// Aqui puedes personalizar otras queries.
  
  public List<Cliente> buscarPorNombre(String nombre) {
    return list("nombre", nombre);
  }
}