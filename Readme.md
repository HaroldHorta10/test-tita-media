# Prueba técnica Tita Media

[Swagger ui](http://localhost:8080/api/tita-media/docs/swagger-ui/index.html)

Contenido dabe de datos
=================


* [Base de datos](src/main/resources/scritp.sql)


Estructura del proyecto
=================
La estructura de este proyecto se basa en principios de arquitectura limpia,
la idea principal es mantener la lógica empresarial aislada de
frameworks y tecnologías específicas. Entonces, se propone la siguiente estructura
para lograr un proyecto comprobable, independiente de decisiones tecnológicas específicas
y escalable.

    .
    ├── configuration              # Configuration classes
    ├── shared
    ├── allcredit
    │   ├── domain
    │   ├── port
    │   └── usecase
    ├── bank
    │   ├── domain
    │   ├── port
    │   └── usecase
    ├── credit
    │   ├── domain
    │   ├── port
    │   └── usecase
    ├── ......
    │   ├── usecase # business logic (services)
    │   │   ├── ExampleService.java
    │   │   └── ExampleServiceImpl.java
    │   ├── domain                      # bussines objects and interface definition for data access (pure java)
    │   │   └── model
    │   │   │   └── Example.java   # bussines objects
    │   │   └── ExampleCreateRepository.java
    │   └── presistence
    │       └── database
    │           ├── entity #jpa entities
    │           │   └── ExampleEntity.java
    │           └── JpaExampleCreateRepository.java # domain data acces implementations
    └── README.md

Este proyecto tiene una estructura de paquete dinámica donde cada paquete está dirigido a un
conjunto de recursos de aplicación o caso de uso y cada paquete debe estar estructurado en
infraestructura, dominio y aplicación excepto el paquete config y shared.
Inicialmente se ha definido paquetes de autorización, prescripción y registro de transacciones.
## domain
- Objetos de negocio
- Definiciones de interfaz para acceso a datos y operaciones

## usecase
- lógica de negocios  (services) 
- usar y orquestar el modelo

## port
- implementaciones de interfaz de dominio
- puntos de entrada como descanso, mensajería, etc.
- tiene una base de datos de subpaquetes dedicada a mantener la implementación y las entidades relacionadas con la base de datos
- tiene una API de subpaquete dedicada a almacenar el punto de entrada de descanso de la API


Reference lectures:
- https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html
- https://github.com/mattia-battiston/clean-architecture-example/blob/master/README.md

Plan de Ejecución
=================

## Despliegue
- Ejecutar script base de datos [Base de datos](src/main/resources/scritp.sql)
- Ejecutar los siguientes comandos ubicado en la raiz del proyecto 
(mvn clean install) y posteriormente (mvn spring-boot:run)
- Abrir swagger
  [Swagger ui](http://localhost:8080/api/tita-media/docs/swagger-ui/index.html)
