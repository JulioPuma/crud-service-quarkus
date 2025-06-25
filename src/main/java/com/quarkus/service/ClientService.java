package com.quarkus.service;

import com.quarkus.database.Database;
import com.quarkus.model.api.Client;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Collection;
import java.util.Optional;

@ApplicationScoped
public class ClientService {
  
  @Inject
  private Database database;
  
  public Collection<Client> getAll() {
    return database.getClientsTable();
  }
  
  public Optional<Client> getById(Long clientId){
    return Optional.ofNullable(database.getClientById(clientId));
  }
  
  public Client create(Client client) {
    return database.addClient(client);
  }
  
  public Client update(Client client) {
    return database.updateClient(client);
  }
  
  public void delete(Long clientId) {
    database.deleteClient(clientId);
  }
}
