# Microservices Starter Kit

This project gives a boiler plate code for starting with microservices journey. This contains totally contains three microservices, two of them are backend microservices running in Grizzly server and one frontend microservice running in nodejs.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

You should have docker and docker-compose installed in your machine before installing this starter kit.

```
Docker
https://www.vultr.com/docs/installing-docker-ce-on-ubuntu-16-04
```

```
docker-compose
https://docs.docker.com/compose/install/
```

### Installing

A step by step series of examples that tell you how to get a development env running

Executing the below script should build the docker images and bring up the containers

```
./startContainer.sh
```

This build the following 3 docker images

```
calculator-service
sub-service
add-service
```

The calculator-service depends on sub-service and add-service. When the docker images are running, it will have following ports mappped

```
calculator-service - runs in port 9000
add-service - runs in port 9001
sub-service - runs in port 9002
```

All the above port are the exposed port, the actual port each image listens is port 80.

## Running the tests

http://localhost:9000/calculator?param1=1&param2=2&operation=add
```
{
   "result":3
}
```
When we execute the above REST API, this actually talks to add-service microservice to perform the operation.

### Break down into end to end tests

Running the add-service

http://localhost:9001/addservice/execute?param1=3&param2=2

```
{
   "result":5
}
```

## Deployment

Change the port number you wanted to expose in docker-compose.yml file

## Built With

* [Grizzly](https://javaee.github.io/grizzly/) - Grizzly embedded server
* [Maven](https://maven.apache.org/) - Dependency Management
* [Jersey](https://jersey.github.io/) - Jersey JAX-RS
* [NodeJS](https://jersey.github.io/) - Jersey JAX-RS

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

* **Venkatesh Mohanram** - *Initial work* - [venkatesh-mohanram](https://github.com/venkatesh-mohanram)

## Acknowledgments

* https://scotch.io/tutorials/speed-up-your-restful-api-development-in-node-js-with-swagger
* https://yurisubach.com/2016/07/14/jersey-dockerize/
* etc

