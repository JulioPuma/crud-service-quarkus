# crud-service-quarkus (branch: with-resteasy)

Este proyecto es una base para futuros desarrollos de servicios CRUD usando **Quarkus 3** y **Java 21**. Su objetivo es servir como plantilla para exponer servicios REST de manera sencilla y eficiente, aprovechando las capacidades de Quarkus y buenas prácticas de desarrollo.

## Características principales

- **Quarkus 3** como framework principal.
- **Java 21** como versión del JDK.
- Exposición de servicios REST usando la dependencia `quarkus-resteasy`.
- Simulación de base de datos en memoria (sin motor externo).
- Uso de **Lombok** para reducir el boilerplate en los modelos.
- Estructura lista para extender y adaptar a nuevos proyectos.

## Estructura del proyecto

- `com.quarkus.controller.ClientController`: Controlador REST para operaciones CRUD sobre clientes.
- `com.quarkus.service.ClientService`: Lógica de negocio y acceso a datos.
- `com.quarkus.database.Database`: Simulación de base de datos en memoria usando una lista de clientes.
- `com.quarkus.model.api.Client`: Modelo de datos para clientes.

## Dependencias principales

- `quarkus-resteasy`: Permite exponer servicios REST.
- `quarkus-resteasy-jackson`: Soporte para serialización/deserialización JSON.
- `lombok`: Facilita la generación automática de getters, setters, builders, etc.
- `quarkus-config-yaml`: Permite la configuración del proyecto usando archivos YAML.

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