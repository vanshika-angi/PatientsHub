# base docker image
FROM openjdk:20
LABEL maintainer="patienthub.net"
ADD target/patients-0.0.1-SNAPSHOT.jar patients.jar
ENTRYPOINT ["java","-jar","patients.jar"]
