# crud-service-quarkus (branch: with-quarkus-rest-client)

Este proyecto es una base para futuros desarrollos de servicios CRUD usando **Quarkus 3** y **Java 21**. Su objetivo es servir como plantilla para exponer servicios REST de manera sencilla y eficiente, aprovechando las capacidades de Quarkus y buenas prácticas de desarrollo.

## Características principales

- **Quarkus 3** como framework principal.
- **Java 21** como versión del JDK.
- Exposición de servicios REST usando la dependencia `quarkus-rest-jackson`.
- Consumo de endpoints internos usando **Quarkus REST Client** (`quarkus-rest-client-jackson`).
- Simulación de base de datos en memoria (sin motor externo).
- Uso de **Lombok** para reducir el boilerplate en los modelos.
- Estructura lista para extender y adaptar a nuevos proyectos.

## Estructura del proyecto

- `com.quarkus.controller.ClientController`: Controlador REST para operaciones CRUD sobre clientes, que utiliza un cliente REST para comunicarse con el endpoint `/third-party`.
- `com.quarkus.controller.ClientThirdPartyController`: Controlador que expone los endpoints `/third-party` (simula un servicio externo).
- `com.quarkus.restclient.ClientThirdPartyRestClient`: Interfaz REST Client para consumir los endpoints `/third-party`.
- `com.quarkus.service.ClientService`: Lógica de negocio y acceso a datos.
- `com.quarkus.database.Database`: Simulación de base de datos en memoria usando una lista de clientes.
- `com.quarkus.model.api.Client`: Modelo de datos para clientes.

## Dependencias principales

- `quarkus-rest-jackson`: Permite exponer servicios REST y serializar/deserializar JSON de manera sencilla.
- `quarkus-rest-client-jackson`: Permite consumir servicios REST externos/internos de forma tipada.
- `lombok`: Facilita la generación automática de getters, setters, builders, etc.
- `quarkus-config-yaml`: Permite la configuración del proyecto usando archivos YAML.

## Configuración

La configuración principal se encuentra en `src/main/resources/application.yaml`, donde puedes ajustar el puerto HTTP, los niveles de log y la configuración del cliente REST. Ejemplo de configuración para el cliente REST:

```yaml
quarkus:
  rest-client:
    third-party-api:
      url: "http://localhost:${quarkus.http.port}"
      scope: "javax.inject.Singleton"
      connect-timeout: 3000
      read-timeout: 8000
```
## Ejecución en modo desarrollo

Puedes ejecutar la aplicación en modo desarrollo (hot reload) con:

```shell
./mvnw quarkus:dev
```
La API estará disponible en http://localhost:9091/clients (puerto configurado en application.yaml).

## Endpoints REST
- `GET /clients` — Listar todos los clientes.
- `GET /clients/{id}` — Obtener cliente por ID.
- `POST /clients` — Crear un nuevo cliente.
- `PUT /clients` — Actualizar un cliente existente.
- `DELETE /clients/{id}` — Eliminar un cliente por ID.
- `GET /third-party` — Listar todos los clientes (simula el servicio externo). 
- `GET /third-party/{id}` — Obtener cliente por ID. (simula el servicio externo)
- `POST /third-party` — Crear un nuevo cliente. (simula el servicio externo)
- `PUT /third-party` — Actualizar un cliente existente. (simula el servicio externo)
- `DELETE /third-party/{id}` — Eliminar un cliente por ID. (simula el servicio externo)
  
## Simulación de base de datos
  No se utiliza ningún motor de base de datos externo. Los datos se almacenan en una lista en memoria (Database.java), lo que facilita pruebas y prototipado rápido.

## Configuración
La configuración principal se encuentra en src/main/resources/application.yaml, donde puedes ajustar el puerto HTTP y los niveles de log.

## Requisitos
- Java 21
- Maven 3.8+

## Empaquetado y ejecución
Para empaquetar la aplicación y crear un JAR ejecutable, utiliza:

```shell
./mvnw package
```

Luego, puedes ejecutar el JAR generado con:

```shell
java -jar target/quarkus-app/quarkus-run.jar
```

## Extensión y adaptación

Este proyecto está diseñado para ser extendido fácilmente, permitiendo agregar nuevas entidades, servicios y controladores según las necesidades de futuros proyectos.