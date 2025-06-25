package com.quarkus.database;

import com.quarkus.model.api.Client;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Singleton class to simulate a database in memory.
 * This class is not thread-safe and should not be used in production.
 * It is intended for demonstration purposes only.
 * It provides a static method to get an instance of the database.
 */

@ApplicationScoped
@Slf4j
public class Database {
  
  private List<Client> clientsTable = new ArrayList(Arrays.asList(
    Client.builder().id(1L).name("Mario Vargas").email("mariovargas@gmail.com").build(),
    Client.builder().id(2L).name("John Doe").email("johndoe@gmail.com").build(),
    Client.builder().id(3L).name("Ricardo Montero").email("ricardomontero@gmail.com").build()));
    
  /**
   * Gets the list of clients.
   *
   * @return a list of clients.
   */
  public List<Client> getClientsTable() {
    log.info("Retrieving clients table with {} clients", clientsTable.size());
    return clientsTable;
  }
  
  /**
   * add a client.
   */
  public Client addClient(Client client) {
    log.info("Adding client: {}", client);
    client.setId(clientsTable.size() + 1L); // Simple ID generation logic
    clientsTable.add(client);
    return client;
  }
  
  /**
   * Updates a client.
   *
   * @param client the client to update.
   */
  public Client updateClient(Client client) {
      log.info("Updating client: {}", client);
      Client clientFound = getClientById(client.getId());
      clientFound.setName(client.getName());
      clientFound.setEmail(client.getEmail());
      return clientFound;
  }
  
  /**
   * Deletes a client by ID.
   *
   * @param id the ID of the client to delete.
   */
  public void deleteClient(Long id) {
    log.info("Deleting client with ID: {}", id);
    Client clientFound = getClientById(id);
    clientsTable.removeIf(client -> client.getId().equals(clientFound.getId()));
  }
  
  /**
   * Gets a client by ID.
   *
   * @param id the ID of the client to get.
   * @return the client with the specified ID, or null if not found.
   */
  public Client getClientById(Long id) {
    log.info("Retrieving client with ID: {}", id);
    return clientsTable.stream()
      .filter(client -> client.getId().equals(id))
      .findFirst()
      .orElseThrow(() -> {
        log.error("Client not found with ID: {}", id);
        return new NoSuchElementException("Client not found with ID: " + id);
      });
  }
  
}
