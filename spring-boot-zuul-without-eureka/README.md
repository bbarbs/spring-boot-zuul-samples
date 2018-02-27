## Introduction
Zuul proxy implementation without eureka but using ribbon for loadbalancing.

## Feature
* Zuul
* Ribbon
* Rxjava

## Gateway Configuration
Sample zuul routes for customer service.
```
zuul:
  ignored-services: "*"
  routes:
    customers:
      path: /customers/**
      serviceId: customer-service
      stripPrefix: false
    check-load-balance:
      path: /check-load-balancing
      serviceId: customer-service
      stripPrefix: false
```

Ribbon implementation without eureka for customer service.
```
customer-service:
  ribbon:
    eureka:
      enabled: false
    listOfServers: http://localhost:8090, http://localhost:8091, http://localhost:8092
    ServerListRefreshInterval: 15000
```

## Testing
To check zuul proxy in action. 
<br/>
Run the gateway project. 
<br/>
Then run the customer project. 
<br/>
After running all project you can access from gateway the customer service api from here: http://localhost:8080/customers

## Checking Ribbon
To check the load balancing working, run the gateway project. 
<br/>
Then in customer service generate jar using **gradle build**. 
<br/>
Then run customer jar ex: **java -Dserver.port=8090 -jar customer-0.0.1-SNAPSHOT.jar** you can run another application in another port like **8091, 8092**.
<br/>
After that you can check it here: http://localhost:8080/check-load-balancing, try to refresh the browser and port will change. 
<br/>
<br/>
For testing you could use Postman or other tools.
