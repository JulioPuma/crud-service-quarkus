package com.quarkus.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CRUDModeEnum {
  PANACHE_ENTITY("PANACHE_ENTITY"),
  PANACHE_REPOSITORY("PANACHE_REPOSITORY"),
  ENTITY_MANAGER("ENTITY_MANAGER");

  final String name;
  
  public static CRUDModeEnum getModoCRUD(String name) {
    for (CRUDModeEnum modo : CRUDModeEnum.values()) {
      if (modo.name.equals(name)) {
        return modo;
      }
    }
    throw new IllegalArgumentException("Invalid ModoCRUD name: " + name);
  }
}