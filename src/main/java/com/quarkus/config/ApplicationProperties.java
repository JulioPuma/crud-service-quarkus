package com.quarkus.config;

import jakarta.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
@Getter
@Setter
public class ApplicationProperties {

  @ConfigProperty(name = "application.crud-mode")
  private String crudMode;
}
