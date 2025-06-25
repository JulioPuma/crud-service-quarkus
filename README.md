# 🚀 Quarkus Playground

![Java](https://img.shields.io/badge/Java-21-blue)
![Quarkus](https://img.shields.io/badge/Quarkus-3-green)
![License](https://img.shields.io/badge/license-MIT-lightgrey)

> 📁 Este repositorio está diseñado como una colección de ejemplos prácticos para aprender a usar **Quarkus 3 con Java 21**. Cada rama contiene un caso de uso específico con distintas dependencias.

---

## 📋 Menú

- [📚 ¿Qué es Quarkus?](#qué-es-quarkus)
- [📘 Sobre este repositorio](#sobre-este-repositorio)
- [🧪 ¿Qué encontrarás en cada rama?](#qué-encontrarás-en-cada-rama)
- [🧩 Lista de dependencias utilizadas](#lista-de-dependencias-utilizadas)
- [📂 Estructura de carpetas](#estructura-de-carpetas)
- [🛠️ Cómo usar este repositorio](#cómo-usar-este-repositorio)
- [📎 Recursos útiles](#recursos-útiles)
- [🧑‍💻 Autor](#autor)

---

## 📚 ¿Qué es Quarkus?

> *"Supersonic Subatomic Java."*

**Quarkus** es un framework moderno y ligero diseñado para correr aplicaciones Java en la nube y en contenedores. Su punto fuerte es el arranque ultra rápido, bajo consumo de memoria y compatibilidad con GraalVM para crear ejecutables nativos.

🔗 Sitio oficial: [https://quarkus.io](https://quarkus.io)

---

## 📘 Sobre este repositorio

Este repositorio contiene varios ejemplos funcionales de cómo integrar **Quarkus 3** con diferentes tecnologías y extensiones.  
Cada ejemplo se encuentra en una **rama distinta**, estructurado para facilitar el aprendizaje y servir como punto de partida para tus propios proyectos.

---

## 🧪 ¿Qué encontrarás en cada rama?

| Disponible | Rama               | Descripción breve                                        | Dependencias clave                                 |
|:----------:|--------------------|----------------------------------------------------------|----------------------------------------------------|
|     ✔️     | `with-quarkusrest` | Uso de `quarkus-rest` como reemplazo moderno de RESTEasy | `quarkus-rest`, `quarkus-jackson`                  |
|     🔜     | `with-resteasy`    | Exposición de endpoints usando `quarkus-resteasy`        | `quarkus-resteasy`                                 |
|     🕐     | `with-panache`     | Persistencia usando Panache con base de datos en memoria | `quarkus-hibernate-orm-panache`, `quarkus-jdbc-h2` |
|     🕐     | `with-kafka`       | Integración con Apache Kafka y eventos reactivos         | `quarkus-smallrye-reactive-messaging-kafka`        |
|     🕐     | `with-security`    | Seguridad con JWT y autenticación OIDC                   | `quarkus-oidc`, `quarkus-security`                 |

---

## 🧩 Lista de dependencias utilizadas

<details>
<summary>Haz clic para desplegar</summary>

- `quarkus-rest` (para exponer endpoints RESTful)
- `quarkus-resteasy` (para crear servicios REST con JAX-RS)
- `quarkus-resteasy-jackson` (para serialización/deserialización JSON
- `quarkus-jackson` (para soporte de JSON en Quarkus) 
- `quarkus-hibernate-orm-panache` (para simplificar la persistencia con JPA) 
- `quarkus-jdbc-h2` (para usar una base de datos H2 en memoria) 
- `quarkus-smallrye-reactive-messaging-kafka` (para integrar con Apache Kafka) 
- `quarkus-security` (para manejar seguridad y autenticación) 
- `quarkus-oidc` (para autenticación con OpenID Connect)
- `quarkus-arc` (CDI para inyección de dependencias)
- `quarkus-logging-json` (para logs en formato JSON)
- `quarkus-scheduler` (para tareas programadas)

</details>

---

## 📂 Estructura de carpetas

```plaintext
📦 src
┣ 📂 main
┃ ┣ 📂 java
┃ ┃ ┗ 📦 org.quarkus
┃ ┃     ┣ 📦 Config
┃ ┃     ┣ 📦 Controllers
┃ ┃     ┣ 📦 Services
┃ ┃     ┣ 📦 Models
┃ ┣ 📂 resources
┃ ┃ ┣ 📄 application.properties
┣ 📂 test
┃ ┗ 📂 java
┃     ┗ 📦 org.quarkus
┃         ┣ 📦 Controllers
┃         ┣ 📦 Services
┃         ┣ 📦 Models
```

---

## 🛠️ Cómo usar este repositorio

```bash
# Clona el repositorio
git clone https://github.com/JulioPuma/crud-service-quarkus.git

# Cambia a la rama de interés
git checkout with-quarkusrest

# Ejecuta el proyecto
./mvnw quarkus:dev
```

> ☝️ Asegúrate de tener Java 21 y Maven instalados, o usa el wrapper (`./mvnw`).

---

## 📎 Recursos útiles

- [📘 Documentación oficial de Quarkus](https://quarkus.io/documentation/)
- [🧰 Extensiones disponibles](https://quarkus.io/extensions/)
- [🧠 Migración de Quarkus 2 a 3](https://quarkus.io/guides/migration)
- [🧊 GraalVM Native Image](https://www.graalvm.org/)
- [🔐 Guía de Seguridad Quarkus](https://quarkus.io/guides/security)

---

## 🧑‍💻 Autor

**Julio Pumahuacre**  
Desarrollador Backend – Java & Microservicios  
[LinkedIn](https://www.linkedin.com/in/juliopuma/)

---

## ⭐ ¿Te sirvió este proyecto?

¡No olvides dejar una estrella ⭐ en el repositorio si te resultó útil!
