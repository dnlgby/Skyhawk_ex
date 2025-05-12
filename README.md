# NBA Stats Backend

This project provides a scalable backend service for ingesting and aggregating NBA player statistics in real-time. It is built using Java (Spring Boot), PostgreSQL, Redis, and Docker.

---

## Features

- RESTful API for logging game statistics per player
- Real-time aggregation of player and team season averages
- Redis-based caching for optimized performance
- PostgreSQL as the relational data store
- Fully containerized and ready for deployment via Docker Compose

---

## Technologies

- Java 17 + Spring Boot 3
- Spring Data JPA (no ORM abstraction layer used)
- Redis (caching layer)
- PostgreSQL 15
- Docker & Docker Compose
- Hibernate 6
- Maven

---

## Project Structure

```
src/
├── controller       # REST endpoints
├── service          # Business logic
├── repository       # Spring Data JPA repositories
├── entity           # JPA entities (Player, Team, GameStat)
├── dto              # Request and response models
├── exception        # Global error handling
```

---

## Getting Started

### Prerequisites

- Java 17
- Maven 3.8+
- Docker & Docker Compose

### Running the Project

```bash
mvn clean package
docker-compose up --build
```

> The service will be available at:  
> http://localhost:8080

---

## API Endpoints

### Log Game Stats

```http
POST /api/stats
```

**Body:**
```json
[
  {
    "playerId": 1,
    "gameDate": "2025-05-12",
    "points": 28,
    "rebounds": 10,
    "assists": 6,
    "steals": 1,
    "blocks": 2,
    "fouls": 2,
    "turnovers": 3,
    "minutesPlayed": 36.5
  }
]
```

---

### Get Player Season Averages

```http
GET /api/players/{playerId}/averages
```

---

### Get Team Season Averages

```http
GET /api/teams/{teamId}/averages
```

---

## Data Initialization

On first run, the following records are seeded into PostgreSQL:

- Team: `Lakers`
- Player: `LeBron James` (ID: 1, Team ID: 1)

Seed logic is handled via `init.sql` mounted in the `db` service.

---

## Testing the System

1. Use Postman or CURL to send stats to `/api/stats`
2. Fetch averages using the `/averages` endpoints
3. View logs in Docker for runtime diagnostics

---

## Scalability Considerations

- **Stateless services** — the backend can horizontally scale across containers
- **Redis caching** — offloads pressure from DB on read-heavy endpoints
- **PostgreSQL** — structured and ACID-compliant; can be extended with replicas
- **Dockerized services** — suitable for Kubernetes or Swarm deployment

---

## Error Handling

Standardized error responses returned as:

```json
{
  "timestamp": "2025-05-12T15:00:00",
  "status": 404,
  "error": "Not Found",
  "message": "Player with ID 99 not found",
  "path": "/api/stats"
}
```

---

## License

This project is released under the MIT License.
