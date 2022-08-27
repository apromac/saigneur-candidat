# ======================================================================
# DOCKERFILE
# CONSTRUCTION DE L'IMAGE DOCKER DU MICROSERVICE "saigneur-candidat"
# ======================================================================
FROM openjdk:11-alpine
LABEL maintainer = "apromac <abraham.tiene@apromac.ci>"

RUN mkdir /usr/local/microservice
WORKDIR /usr/local/microservice
COPY target/*.jar saigneur-candidat.jar

EXPOSE 9003
ENTRYPOINT ["java", "-jar", "saigneur-candidat.jar"]
