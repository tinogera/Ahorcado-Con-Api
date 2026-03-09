# 🎮 Ahorcado API

API REST desarrollada en Java con Spring Boot como backend del juego Ahorcado.

## 🛠️ Tecnologías
- Java 25
- Spring Boot 4.0.3
- Spring Data JPA
- MySQL 8
- Maven

## 📦 Estructura del proyecto
src/
├── model/
│   ├── Jugador.java
│   ├── Partida.java
│   └── Palabra.java
├── repository/
│   ├── JugadorRepository.java
│   ├── PartidaRepository.java
│   └── PalabraRepository.java
└── controller/
    ├── JugadorController.java
    ├── PartidaController.java
    └── PalabraController.java

## 🔗 Endpoints

### Jugadores
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/jugadores` | Lista todos los jugadores |
| GET | `/jugadores/{id}` | Busca jugador por ID |
| GET | `/jugadores/nombre/{nombre}` | Busca jugador por nombre |
| POST | `/jugadores` | Crea un jugador nuevo |
| PUT | `/jugadores/{id}` | Actualiza puntos y racha |

### Palabras
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/palabras` | Lista todas las palabras |
| GET | `/palabras/random` | Devuelve una palabra aleatoria |

### Partidas
| Método | Ruta | Descripción |
|--------|------|-------------|
| GET | `/partidas` | Lista todas las partidas |
| GET | `/partidas/jugador/{id}` | Lista partidas de un jugador |
| POST | `/partidas` | Guarda una partida nueva |

## ⚙️ Configuración
Crear el archivo `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ahorcadoApi
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
```

## 🗃️ Base de datos
```sql
CREATE DATABASE ahorcadoApi;
```
Las tablas se crean automáticamente al iniciar la aplicación.

## 🚀 Próximamente
- [ ] App de consola que consume la API
- [ ] Lógica del juego Ahorcado
- [ ] Sistema de puntos y rachas
