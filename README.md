# Read Me First

Home assignment Demo API

# Getting Started

API documentation is available by following links (after up & run):

http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config
and
http://localhost:8080/api-docs

Build and Run application is simple, just run two Docker commands below

## Docker
to build application container - from root project:

```shell
docker-compose build
```

to up and run:

```shell
docker-compose up
```

State after run : http://localhost:8080/actuator/health

Quick check functionality: http://localhost:8080/api/v1/string?query=rest   
