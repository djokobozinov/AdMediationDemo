## Ad Mediation Demo

### This project is only for demonstration purpose. It is a service that will manage adnetworks list. 

- I'm using Spring Boot for this application.
- AdNetworks are stored using H2(in memory database), for the simplicity of the demostration, for production I would use PostgreSQL or MongoDB maybe. AdNetworks are accessed via JPA.

## How to start the project

I'm runing the project on Linux, and I have Java version 11.

1. Start project with typing this command in your command line `./mvnw spring-boot:run` 

## Project Spec

There are 2 entities:

```AdNetwork(id, name, minAndroidOsVersion, blockedCountries, priorityNetwork)```

AdNetwork hold data about the ad network SDK, for example AdMob, and other details related.<br /> 
If priorityNetwork is set, AdUnit for the AdNetwork will be given to user only if priority network is not in the list.
(e.q. Admob and AdMob-OptOut don't go together)

```AdUnit(id, countryCode, priority, type, adnetwork_id)```

AdUnit holds data about diferent instances of the AdNetwork that are displayed, diferent types like banner or interestial and for different countries. AdUnit also holds data for the priority score of every unit.<br />
The higher the number of the priority is, that means the better the AdUnit is doing.

Entites are converted to DTOs when are returned from rest controllers.

For testing purposes dummy data will be preloaded on application start in LoadDatabases.java->initDatabase()

## Test api calls

### 1. Retrieve list of ad networks from mobile app - GetAdUnits
```curl --location --request GET 'http://localhost:8080/adunit?countryCode=CN&osVersion=8'```
