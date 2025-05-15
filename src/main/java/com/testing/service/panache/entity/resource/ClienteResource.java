package com.testing.service.panache.entity.resource;

import com.testing.service.panache.entity.Cliente;
import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

/**
 * Esta clase genera automaticamente:
 * </br> GET /clientes
 * </br> GET /clientes/{id}
 * </br> POST /clientes
 * </br> PUT /clientes/{id}
 * </br> DELETE /clientes/{id}
 * </br> Sin necesidad de escribir controlador adicional
 */
@ResourceProperties(path = "clientes-entity")
public interface ClienteResource extends PanacheEntityResource<Cliente, Long> {}
