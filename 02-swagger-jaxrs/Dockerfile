FROM maven:3.5.4-jdk-8

RUN mkdir -p /opt/app
WORKDIR /opt/app

COPY pom.xml /opt/app/

RUN mvn install

COPY src /opt/app/src
RUN mvn package

EXPOSE 80

CMD ["mvn", "exec:java"]
