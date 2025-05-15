package com.testing.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente {
  @Id
  @GeneratedValue
  public Long id;
  public String nombre;
  public String correo;
}