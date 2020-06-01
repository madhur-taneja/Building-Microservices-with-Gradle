# Building Microservices with Gradle

A microservice architecture consisting of 3 microservices that interact with each other in Spring Boot using Gradle in Java 8

Open and view the Project using the `.zip` file provided or at my [Github Repository](https://github.com/madhur-taneja/Building-Microservices-with-Gradle)

## Table of Contents
- [Getting Started](#getting-started)
	- [Tools Required](#tools-required)
	- [Installation](#installation)
- [Development](#development)
    - [1. Microservice architecture with Hardcoded Data](#1-microservice-architecture-with-hardcoded-data)
	- [2. Microservice architecture with an embedded Database](#2-microservice-architecture-with-an-embedded-database)
	- [3. Microservice architecture with an embedded Database and eureka as service discovery](#3-microservice-architecture-with-an-embedded-database-and-eureka-as-service-discovery)
	- [4. Dockerized Microservice architecture with an embedded Database and eureka as service discovery](#4-dockerized-microservice-architecture-with-an-embedded-database-and-eureka-as-service-discovery)
- [Running the App](#running-the-app)
- [Resources](#Resources)

## Getting Started

The project has 5 branches: `master`, `hard-coding`, `mongo`, `eureka` and `docker`

* `master` contains aggregate code of all branches
* `hard-coding` contains hardcoded data for APIs
* `mongo` contains embedded mongodb connection with the services
* `eureka` contains service discovery for the microservices
* `docker` contains a dockerized version of the app

![Architecture](images/Microservice_architecture.png)

This application doesn't have a proper UI and focuses on the Backend and the Database part

### Tools Required

You would require the following tools to develop and run the project:

* MongoDB
* Docker
* Java 8
* SpringBoot
* Gradle
* A text editor or an IDE (like IntelliJ)

### Installation

* Setup Java 8
  * Follow the steps mentioned [here](https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/)

* Install Gradle in your system. It’s highly recommended to use an installer:
  * [SDKMAN](https://sdkman.io/)
  * [Homebrew](https://brew.sh/)
  
  As a last resort, if neither of these tools suit your needs, you can download the binaries from [Gradle Org](https://www.gradle.org/downloads)

* Setup MongoDB
  * Follow the steps mentioned[here](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)

## Development

#### 1. Microservice architecture with Hardcoded Data

* Create 3 different project using [Spring Initializr](https://start.spring.io/).
* Create resources and model classes for all of them.
* Building movie catalog service API, movie info service API and rating data service API.
* Creating replicas in the movie catalog service for the classes used in the services other two services.
* Have movie catalog service API call the other two services.
* The code will be in the `master` branch.

#### 2. Microservice architecture with an embedded Database

* The services created in the previous step will be used to create an architecture with embedded DB.The hardcoded data will be removed from the app.
* The code will be in the `mongo` branch.
* Two databases have been created, one for each `Movie-Info-Service` and `Rating-data-Service`.
* New Entities were made in `Rating-data-Service`.
* PostMapping methods were added for the above mentioned two services.
* Still hardcoded URL's are used from `Movie-Catalog-Service` but will be changed in future.

#### 3. Microservice architecture with an embedded Database and eureka as service discovery

* The code will be in the `eureka` branch.
* New spring boot application called `disovery-server` is created whioh acts as the Eureka Server. All services are registered here.
* New Dependencies are added in the other 3 services to act as Eureka Clients and are assigned name in the `application.properties` files.
* Hardcoded URL's are updated with the service names.
* The registered services can be seen below:  
    ![Eureka Server GUI](images/Eureka.png)
* The output still remains the same:  
	Catalog-1  
    ![Catalog_output_1](images/Catalog-1.png)	
	
	Catalog-2  
    ![Catalog_output_2](images/Catalog-2.png)  

#### 4. Dockerized Microservice architecture with an embedded Database and eureka as service discovery

* The code will be in the `docker` branch.
* Yet to be implemented

For details now how everything has been implemented, refer the source code.

## Running the App

### Starting the Database

* Start the mongo database using the following commands:
  * Open a terminal and run `mongod`
  * Open another terminal and run `mongo`
    * You can run mongo related commands here 
  
  Alternatively, open `MongoDB Compass` and start a new connection to the host at `http://localhost:27017/`  

### Starting the Microservices 

There are multiple commands that are useful when working with gradle

* Open terminal in the root directory of each of the service
  * To build the project, use the following command:
  ```
    gradle build
  ```
  * To run the project, use the following command:
  ```
    gradle bootRun
  ``` 

Start the service-discovery(eureka) first and then all the microservices

## Resources

* Java Brains [Tutorial](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTZSKAFG6aCDVDP86Qx4lNas)
