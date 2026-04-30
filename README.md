# High-Performance URL Shortener

#
Scalable URL Shortener service built using Java and Spring Boot, designed to handle high read/write traffic with low latency.
The system supports URL encoding/decoding, caching for fast redirection, and rate limiting to prevent abuse under high traffic conditions.

##Architecture
-Microservice-style design with layered architecture:
-Controller -> Service -> Repository
- Redis used for caching frequently accesed URLs
- MySQL used for persistent storage
- Rate Limiting implemented at API Gateway level


  ### Tech Stack
  - Java
  - Spring Boot
  - Spring Data JPA
  - MySQL
  - Redis
  - Apache Kafka
  - Maven
 
  #### Features
  - Shorten long URLs into unique short links
  - Redirect to original URL in O(1) time
  - Redis caching for fast lookup and reduced DB load.
  - Rate limiting to preent abused under high traffic
  - RESTful APIs for URL creation and retrival.

🚀 API Endpoints
| Method | Endpoint             | Description                 |
| ------ | -------------------- | --------------------------- |
| GET    | `/`                  | Health check                |
| POST   | `/shorten`           | Create short URL            |
| GET    | `/r/{shortCode}`     | Redirect to original URL    |
| GET    | `/stats/{shortCode}` | Get analytics (click count) |

Supports HTTP 302 redirection, click tracking, and RESTful API design
