# Proyecto - Registro de Usuarios

## Descripción

Este proyecto tiene como objetivo desarrollar una aplicación para la administración de usuarios utilizando tecnologías modernas como Java Spring, MySQL y Docker Compose. La aplicación permitirá a los usuarios registrarse varias veces y ver su historial de registros.

---

## Casos de Uso

- USUARIO puede registrarse varias veces.
- USUARIO puede ver historial de registro.

---

## Arquitectura

El proyecto utiliza una arquitectura de MVC (Model View Controller) para facilitar el desarrollo de la aplicación.

### Tecnologías

- **Java**
  - Maven (Administrador de Paquetes)
  - Data JPA (ORM para la persistencia de datos)
  - Thymeleaf (Motor de plantillas para la vista)
- **MySQL** (Base de datos relacional)
- **Docker Compose** - No Obligatorio - (Orquestación de contenedores)

---

## Creación del Proyecto

### Creación del Proyecto Java

1. Entrar a [Spring Initializer](https://start.spring.io/).
2. Crear el proyecto con los siguientes metadatos:
   - **Group:** com.registry
   - **Artifact:** personhood
   - **Name:** personhood
   - **Description:** App for user history
   - **Package name:** com.registry.personhood
   - **Java:** 21
3. Añadir las dependencias necesarias:
   - **Spring Web:** Para construir aplicaciones web con Spring MVC.
   - **Spring Data JPA:** Para la interacción con la base de datos mediante ORM.
   - **Thymeleaf:** Para la generación dinámica de vistas HTML.
   - **MySQL Driver:** Para la conexión con la base de datos MySQL.

- Descargar el proyecto y descomprimirlo en tu directorio de trabajo.

### Creación de la Base de Datos

1. Activar el motor de base de datos (XAMP, MySQL, Docker, etc.).
2. Obtener el usuario y la contraseña para la configuración y conexión desde Spring.
3. Crear una tabla `users`:

```sql
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    public_id VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(20),
    gender ENUM('Masculino', 'Femenino', 'Otro'),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Ejecución del proyecto

### Como ejecutar el proyecto sin Docker

1. Clonar el proyecto
2. Instalar Java y Maven
3. Añadir las configuraciones

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_datos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

6. instalar las dependencias con `mvn clean install`
7. Ejecutar el proyecto usando `mvn spring-boot:run`

### Como ejecutar el proyecto con Docker

1. Clonar el proyecto
2. Crear un archivo `.env`

```env
DB_NAME=nombre_base_datos
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_contraseña
```

1. Abrir la terminal, usar el comando `docker compose up`
2. Abrir otra terminal, usar el comando `docker docker exec database bash`
   1. Ingresar a al motor de MySQL con `mysql -u root -p`, ingresar la contraseña que haya en la variable de entorno `DB_PASSWORD`
   2. En la base de datos con el nombre de `DB_NAME`, usarla y crear la tabla de usuarios anteriormente definida.

---

## Modelos

### Usuario (User)

#### Campos

- **Nombres (firstName):** STRING
- **Apellidos (lastName):** STRING
- **Correo Electrónico (email):** STRING
- **Teléfono (phone):** STRING
- **Género (gender):** STRING
- **Creado en (created_at):** TIMESTAMP

## Diagramas

[https://observablehq.com/d/2cefe06debf052c5](https://observablehq.com/d/2cefe06debf052c5)
