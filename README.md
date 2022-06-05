# Ad Mediation Demo

## This project is only for demonstration purpose. It is a service that will manage adnetworks list. 

- I'm using Spring Boot for this application.
- AdNetworks are stored using H2(in memory database), for the simplicity of the demostration, for production I would use PostgreSQL or MongoDB maybe. AdNetworks are accessed via JPA.

# How to start the project

I'm runing the project on Linux, and I have Java version 11.

1. Start project with typing this command in your command line `./mvnw spring-boot:run` 

# Entities

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

# Documentation

## 1. Retrieve list of ad networks from mobile app
Filtered list of adUnits for every adNetwork is returned ordered by prioirty.

Local:

```curl --location --request GET 'http://localhost:8080/adunit?countryCode=SI&osVersion=10'```

AppEngine:

```curl --location --request GET 'https://admediationdemo-352416.uc.r.appspot.com/adunit?countryCode=SI&osVersion=10'```

```
[
    {
        "id": 3,
        "countryCode": "SI",
        "priority": 619,
        "type": "BANNER",
        "adNetwork": "AdMob"
    },
    {
        "id": 7,
        "countryCode": "SI",
        "priority": 522,
        "type": "BANNER",
        "adNetwork": "Facebook"
    }
]
```
Request parameters are optional.

## 2. Retrieve list of ad networks from dashboard
A list of Ad Networks is returned (AdMob, Facebook, Unity ...) with all the details. 
Each ad network has list with ad units with all the details.

In the dashboard there could be a grid that will display all the details about every AdNetwork, with option to edit them.
Every AdNetwork will have expand button. When AdNetwork is expanded, a sublist with AdUnits and option to edit them will be displayed.

Local:

```curl --location --request GET 'http://localhost:8080/adnetwork'```

AppEngine:

```curl --location --request GET 'https://admediationdemo-352416.uc.r.appspot.com/adnetwork'```

```
[
    {
        "id": 1,
        "name": "AdMob",
        "minAndroidOsVersion": 9,
        "blockedCountries": null,
        "priorityNetworkId": null,
        "adUnits": [
            {
                "id": 1,
                "countryCode": "US",
                "priority": 805,
                "type": "BANNER",
                "adNetwork": null
            },
            {
                "id": 3,
                "countryCode": "SI",
                "priority": 668,
                "type": "BANNER",
                "adNetwork": null
            },
            {
                "id": 4,
                "countryCode": "CN",
                "priority": 626,
                "type": "BANNER",
                "adNetwork": null
            },
            {
                "id": 2,
                "countryCode": "DE",
                "priority": 94,
                "type": "INTERSTITIAL",
                "adNetwork": null
            }
        ]
    },
    ...
]
```

## 3. Update list of ad networks
Updating the priority with new calculated priority from pipeline for ad unit that we need to update.
Sending id(the ad unit id) and the new priority.

Local:

```
curl --location --request PUT 'http://localhost:8080/adunit' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "id": 7,
        "priority": 870
    },
    {
        "id": 3,
        "priority": 329
    }
]'
```

AppEngine:

```
curl --location --request PUT 'https://admediationdemo-352416.uc.r.appspot.com/adunit' \
--header 'Content-Type: application/json' \
--data-raw '[
    {
        "id": 7,
        "priority": 870
    },
    {
        "id": 3,
        "priority": 329
    }
]'
```