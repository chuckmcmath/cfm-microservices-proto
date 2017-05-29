# cfm-microservices-proto
A multi-module project showing the interactions between a couple of simple microservices, eureka, and zuul.

## Description ##
This project demonstrates an example microservice setup using the [Netflix OSS tools](https://netflix.github.io/). The components include:
- an Eureka server, which provides service registration and lookup,
- a Zuul edge service, which provides a front-end gateway to deployed microservices,
- a simple microservice named 'service-one', and finally,
- another simple microservice named 'service-two'

## Environment ##
The project was developed with the following tools:
- Spring-Tool-Suite 3.8.4.RELEASE from [Spring.io](https://spring.io/tools) (as I understand it, this is equivalent to Eclipse with some sort of Spring plugin)
- Java version 1.8.0.111

... and that's really it. I thought there'd be more here.

## Building ##
- check out the repository
- import 'Existing Maven Project' in STS/Eclipse
- right-click on the parent project and choose `Run -> Maven clean` then `Run -> Maven install`
- if you're a console jockey do a `mvn clean install` or `mvn clean package` in the parent directory.

## Deploying and Running ##
You'll need at least four console windows for this. Each command should be executed in a console window, and they should be started in the order shown below.

`cd {project directory}\eureka-server; java -jar target\eureka-0.0.1-SNAPSHOT.jar`

You should see a bunch of info statements spit out in the console. When it settles down, use a browser to hit the [Eureka endpoint](http://localhost:8761). Once that's up, start up the microservices. Service one first:

`cd {project directory}\service-one; java -jar target\serviceone-0.0.1-SNAPSHOT.jar`

Let the console settle down once again. Refresh the Eureka page above. You should see a registration entry for SERVICE-ONE. And that entry should tell you service one is deployed using port 8070.

Repeat the process for service-two:

`cd {project directory}\service-two; java -jar target\servicetwo-0.0.1-SNAPSHOT.jar`

Refresh the Eureka page. You should see not only SERVICE-ONE but also SERVICE-TWO registered. Please note that service two is deployed to port 8090.

Finally, start up Zuul:

`cd {project directory}\zuul-gateway; java -jar target\zuul-0.0.1-SNAPSHOT.jar`

Zuul won't show up in the Eureka list. Note it's installed on port 8080.

## Testing Everything ##

Each service implements a couple of endpoints:

 - `/data` : a simple endpoint that shows a message identifying the service
 - `/my-instances` : an array of information about each instance of the service
 along with typical spring boot actuator endpoints:
 - `/health` : a health indication
 - `/info` : displays some information about the service
 
 You can access each services' endpoint simply by hitting the port with a web page. For example [Service one data endpoint](http://localhost:8070/data). [Service two info endpoint](http://localhost:8090/info). Each of the endpoints above should be accessable through either service. The data you'll see should be similar, but not identical.
 
 Zuul provides a unified front-end to the deployed microservices. With Zuul, you would navigate to:
 
- http://localhost:8080/service-one/data instead of http://localhost:8070/data
- http://localhost:8080/service-two/data instead of http://localhost:8090/data
 
 All of the service-one endpoints are mapped to the service-one/ path, and all of the service-two endpoints are mapped to the service-two/ path. Zuul provides the mechanism to centralize access, filter requests, and shield direct access to microservices from sources except from the gateway itself.


 
 




