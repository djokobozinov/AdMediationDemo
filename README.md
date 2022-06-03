## Ad Mediation Demo

### This project is only for demonstration purpose. It is a service that will manage adnetworks list. 

- I'm using Spring Boot for this application.
- AdNetworks are stored using H2(in memory database), for the simplicity of the demostration, for production I would use PostgreSQL or MongoDB maybe. AdNetworks are accessed via JPA.

## How to start the project

I'm runing the project on Linux, and I have Java version 11.

1. Start project with typing this command in your command line `./mvnw spring-boot:run` 

## Project Specification

There are 2 entities:

```AdNetwork(id, name, minAndroidOsVersion)```

AdNetwork hold data about the ad network SDK, for example AdMob, and other details related like minimimum android version suported.<br /> 

```AdUnit(id, countryCode, priority, adnetwork_id)```

AdUnit holds data about diferent instances of the AdNetwork that are displayed, diferent types like banner or interestial and for different countries. AdUnit also holds data for the priority score of every unit.<br />
The higher the number of the priority is, that means the better the AdUnit is doing.
