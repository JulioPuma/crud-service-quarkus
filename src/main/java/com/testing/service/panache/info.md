## Explicacion del uso de panache y exponerlo a travez de servicio REST

| Característica                           | PanacheEntityResource     | PanacheRepositoryResource              |
|------------------------------------------|---------------------------|----------------------------------------|
| ¿Requiere una clase repositorio?         | ❌ No                      | ✅ Sí                                   |
| ¿La entidad debe extender PanacheEntity? | ✅ Sí                      | ❌ No (usa entidad POJO + repositorio)  |
| ¿Mayor flexibilidad en lógica de datos?  | ❌ Menos flexible          | ✅ Más control con lógica personalizada |
| ¿Simplicidad para prototipos rápidos?    | ✅ Ideal para CRUD básicos | ⚠️ Mejor si necesitas más control      |


### **Ambas interfaces provienen de la misma extensión**
``` xml
<dependency>
<groupId>io.quarkus</groupId>
<artifactId>quarkus-hibernate-orm-rest-data-panache</artifactId>
</dependency>
```

Esta librería expone:
- PanacheEntityResource 
- PanacheRepositoryResource 
- RestDataResource 
- Anotaciones como @ResourceProperties

### **¿Cuál deberías usar?**

**Usa PanacheEntityResource si:**

- Solo necesitas un CRUD rápido
- No necesitas lógica personalizada en repositorios

**Usa PanacheRepositoryResource si:**

- Quieres separar la lógica de datos (buena práctica)
- Planeas agregar métodos personalizados en el repositorio

