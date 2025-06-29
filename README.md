## 🚀 CRUD Service Quarkus
Este proyecto demuestra cómo implementar operaciones CRUD en Java usando Quarkus, integrando diferentes formas tradicionales de acceso a la base de datos y buenas prácticas modernas de desarrollo.
<hr></hr>

## 📚 Descripción
El objetivo principal es mostrar tres formas clásicas de interactuar con la capa de persistencia en Java:
- **PanacheEntityBase**
- **PanacheRepository**
- **EntityManager (JPA estándar)**

Además, se utilizan herramientas modernas como Lombok y MapStruct para reducir el código repetitivo y facilitar el mapeo de objetos.

<hr></hr>

## 🛠️ Tecnologías y dependencias principales
- **Quarkus**: Framework principal para aplicaciones Java nativas y eficientes.
- **H2 Database**: Base de datos embebida para pruebas y desarrollo rápido.
- **Hibernate ORM**: Implementación de JPA para el mapeo objeto-relacional.
- **Panache**: Abstracción sobre JPA que simplifica el acceso a datos.
- **Lombok**: Generación automática de getters, setters, constructores, etc.
- **MapStruct**: Mapeo automático entre entidades y DTOs.

Fragmento relevante del pom.xml:
```
<!-- Quarkus REST -->
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-rest-jackson</artifactId>
</dependency>

<!-- Hibernate ORM (JPA) -->
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm</artifactId>
</dependency>

<!-- Panache ORM -->
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-hibernate-orm-panache</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>io.quarkus</groupId>
    <artifactId>quarkus-jdbc-h2</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>${lombok.version}</version>
    <scope>provided</scope>
</dependency>

<!-- MapStruct -->
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>${mapstruct.version}</version>
</dependency>
```
<hr></hr>

## 🏗️ Estructura del proyecto
- `/model` 
  - entity: Entidades JPA (anotadas para generación automática de tablas)
  - api: DTOs para la API
  - mapper: Interfaces de mapeo con MapStruct
- `/service`
  - dao: Lógica de acceso a datos, eligiendo el modo de persistencia
  - entitymanager: Implementación usando EntityManager
  - repository: Implementación usando PanacheRepository
- `/controller`: Exposición de endpoints REST
- `/config`: Configuración de propiedades de la aplicación
- `/util`: Utilidades y enums
<hr></hr>

## 🧩 Modos de persistencia soportados
Puedes elegir el modo de persistencia cambiando la propiedad `application.crud-mode` en el archivo de configuración:
- **PANACHE_ENTITY**
- **PANACHE_REPOSITORY**
- **ENTITY_MANAGER**

<hr></hr>

## ⚡ ¿Cómo funciona?
1. El controlador expone endpoints REST para operaciones CRUD.
2. El servicio selecciona dinámicamente el modo de persistencia según la configuración.
3. El DAO implementa la lógica para cada modo (PanacheEntityBase, PanacheRepository, EntityManager).
4. Se usan MapStruct y Lombok para simplificar el código y el mapeo de datos.
<hr></hr>

## 📝 Notas
- Este proyecto es ideal para aprender y comparar diferentes formas de acceso a datos en Quarkus.
- Puedes cambiar fácilmente el modo de persistencia para experimentar con cada enfoque.
<hr></hr>

## ✨ Autor
Desarrollado por Julio Pumahuacre
<hr></hr>
¿Listo para probar diferentes formas de hacer CRUD en Quarkus? ¡Explora, aprende y experimenta! 🚦
<hr></hr>