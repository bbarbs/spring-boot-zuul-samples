## Introduction
Zuul implementation with eureka server.

## Feature
* Zuul
* Eureka
* Rxjava

## Gateway Configuration
Added are the configuration for customer routes and checking load balance if working. Both are in customer service project.
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

## Zuul FallbackProvider
In gateway project added is the sample FallbackProvider for zuul. Sample below is the response when customer service is down. See [here](https://github.com/bbarbs/spring-boot-zuul-samples/blob/master/spring-boot-zuul-with-eureka/gateway/src/main/java/com/gateway/config/HystrixZuulFallbackConfig.java)
```
{
  "fallback": "Service Down"
}
```
## Testing 
To check zuul proxy run the first the eureka server which is the server folder.
<br/>
Then run the gateway project.
<br/>
Then run the customer project.
<br/>
After running all project you can access from gateway the customer service from here: http://localhost:8080/customers

## Checking Ribbon
To check the load balancing run the server and gateway.
<br/>
Then in customer service generate jar using **gradle build**.
<br/>
Then run customer jar ex: **java -Dserver.port=8090 -jar customer-0.0.1-SNAPSHOT.jar** you can run another application in another port like 8091, 8092.
<br/>
After that you can check it here: http://localhost:8080/check-load-balancing, try to refresh the browser and port will change.
<br/>
<br/>
For testing you can use Postman or other tools.
