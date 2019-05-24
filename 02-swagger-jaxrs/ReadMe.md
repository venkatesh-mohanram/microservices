# Swagger in JAX-RS

This project aims to create a template for integrating the swagger documentation into a JAX-RS application

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You should have docker or maven installed in your machine before installing this starter kit.

```
Docker
https://www.vultr.com/docs/installing-docker-ce-on-ubuntu-16-04
```
```
Maven
https://maven.apache.org/download.cgi
```
### Development
* Create the maven project using the following command
```
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 -DarchetypeGroupId=org.glassfish.jersey.archetypes -DinteractiveMode=false -DgroupId=com.microservices.demo -DartifactId=swagger-jersey-service -Dpackage=com.microservices.demo.swagger -DarchetypeVersion=2.17
```
* Add the following dependencies in your pom.xml
```xml
<dependency>
    <groupId>org.glassfish.jersey.containers</groupId>
    <artifactId>jersey-container-grizzly2-servlet</artifactId>
</dependency>
<dependency>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-jersey2-jaxrs</artifactId>
    <version>${swagger-jersey2-jaxrs.version}</version>
</dependency>
```
* Annonate your resource class
```
@Api(
   value = "Calculator Resource",
   description = "Service to evalaute expressions"
   )
```
* Add swagger-ui code into your project
Download the swagger-ui from below git-hub. Copy the dist folder and paste it into your src/main/resource/swagger-ui directory
```
https://github.com/swagger-api/swagger-ui
* Update the swagger url in the index.html
```
### Installing

A step by step series of examples that tell you how to get a development env running

#### Executing via Docker
Execute the below command to build the docker image and run it

```
sudo docker build --tag swagger-jersey-service .
sudo docker run -p 8080:8080 -v maven-repo:/root/.m2 -t -i swagger-jersey-service
```
OR
```
sudo docker run -d -p 8080:8080 -v maven-repo:/root/.m2 -t -i swagger-jersey-service
```

The use of -d command will run in a detached mode, meaning it will be running in background and we can use the below command to list the docker processes

```
sudo docker ps
```
#### Executing via the maven

```
mvn clean install
mvn exec:java
```

## Running the tests

Open the following URL in the browser to see the swagger document. This is the auto generated swagger document based on the annotations
```
http://localhost:8080/myapp/swagger.json
```
Open the following URL in the browser to see the swagger-ui, where you can even test the application with 'Try now' option. Note the '/' at the end of the URL, without that the link wont work
```
http://localhost:8080/docs/
```

## Deployment

Configure the port appropriately while deploying in production

## Built With

* [Swagger](https://swagger.io/) - The Swagger documentaion
* [Maven](https://maven.apache.org/) - Dependency Management
* [Grizzly](https://javaee.github.io/grizzly/) - Grizzly embedded server
* [Jersey](https://jersey.github.io/) - Jersey JAX-RS

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Venkatesh Mohanram** - *Initial work* - [venkatesh-mohanram](https://github.com/venkatesh-mohanram)

## Acknowledgments

* StackOverFlow
* etc

