package com.quarkus.model.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Client {
  private Long id;
  private String name;
  private String email;
}