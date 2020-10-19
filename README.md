---
title: Centene Coding Challenge 
category: REST API, Spring Boot Application
layout: 2017/sheet
tags: [Featured]
updated: Oct 11 2020
keywords:
  - Spring
  - MySQL
  - Spring Security
  - Mockito
---

Centene Coding Challenge
---------------

## Introduction
We have designed a back-end application for a hypothetical health care provider. This application is built on the following components: 
  - Spring boot (Java) backend utilizing hibernate and JPA for data persistance
  - Management of MySQL database that supports a one-to-many relationship between:
    - Enrollees (users) who have enrolled in a health care plan
    - Dependents of Enrollees who do not have their own distinct health care plan
  - Security using
  - Testing using

This project incorporates many relevant features of a robust backend application including but not limited to:
 - REST API
 - Relational Database management
 - Microservice-based architecture featuring
   - Spring security
   - Automated testing
   - Profiles for dynamic testing and application building

### Structure
This project uses [Spring][spring] boot and REST architecture to dynamically maintain repositories. It relies on inversion of control principles with dependency injection to ensure safe relational management. Application user input is accepted over HTTP.

### Backend
This project is managed with the [Apache Maven][maven] management tool.

The backend architecture is reasonably standard for a Spring boot application; POJOs used to model important objects are reside in the `model` folder. Using Spring annotations, these models are transformed into `JpaRepository`s in the `repo` directory. HTTP requests along with conversions between DTOs and Spring Entities are handled in the `controller` classes. CRUD operations are implemented by methods found in the `service` folder.

### Data Persistance
Data persistance has been implemented using the hibernate framework and MySQL to support a RESTful interface.

### Security

### Testing



