<div align="center">
<h1>Kalah</h1>

[**Game Rules**](https://en.wikipedia.org/wiki/Kalah)
</div>

<hr />

<!-- prettier-ignore-start -->
[![MIT License][license-badge]][license]
<!-- prettier-ignore-end -->

## Table of Contents
<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->


<!-- END doctoc generated TOC please keep comment here to allow auto update -->

## About
This solution consists of two applications implemented using Java (Spring Boot Service) and Javascript (Angular Framework), details are pointed below:

* `kalah-backend`: Spring Boot service, responsible for creating and managing the game sessions which are stored in a PostgreSQL database server.

* `kalah-frontend`: Angular project responsible for the user interface, it comunicates with the `kalah-backend` in order to create and update the status of the gaming board as well as beign responsible for presenting the game winner once the game is end.

## Architecture


## Technologies
* `Spring Boot v2.5.0`, for creating RESTful API;
* `Spring Data`, for managing the Database Server entities;
* `JUnit`, used for unit testing of the application;
* `Swagger`, used for API documentation;
* `Lombok`, used for annotating getters and setters methods;
* `Model Mapper`, used for object mapping;
* `PostgreSQL`, used to store the necessary data;
* `Docker and Docker-Compose`, containerization of the services and linking containers;
* `Angular v12`, implementation of user interface;
* `Angular Material`, Material Design components used in Angular;
* `Angular Flex Layout`, creation of responsive layouts;

## Prerequisites
Make sure you have installed all of the following prerequisites on your development machine:
* `Node.JS` and `Angular CLI`, for building the `kalah-frontend`;
* `Java 11` and `Maven`, for building the `kalah-backend`;
* `Docker` and `Docker-Compose`, to build and run the application containers;

## Installation
> TODO

## Future Improvements
* `kalah-frontend`: 
  * Create a user session management module in order to authenticate and enable multi/single player sessions;
  * Creation of a matchmaking module to manage the current available games waiting for new players;
  * Creation of new components to divide better the responsabilities between the communications with REST APIs;

* `kalah-backend`:
  * Management of players and their sessions using JWT tokens;
  * Matchmaking mechanim to enable online multiplayer gameplay;
  * Implementation of caching systems like Redis to improve performance of the system;
  * Implementations should consider a microservices architecture in order to be scalable to manage as much users/game sessions;

* `General`:
  * Project build, versioning and deployment automatization;
  * Re-design of the solution to be a Cloud Native application beign capable of handling with autoscaling (Kubernetes and Cloud Native Apps can be considered);
  

## Contributors
Nathan Ribeiro
* [Github](https://github.com/nathanlogus)
* [LinkedIn](https://www.linkedin.com/in/nathanlogus/)

## LICENSE

[MIT](LICENSE)

<!-- prettier-ignore-start -->
[license-badge]: https://img.shields.io/npm/l/@testing-library/react.svg?style=flat-square
[license]: https://github.com/testing-library/react-testing-library/blob/main/LICENSE
<!-- prettier-ignore-end -->
