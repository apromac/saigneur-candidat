# ======================================================================
# DOCKERFILE
# CONSTRUCTION DE L'IMAGE DOCKER DU MICROSERVICE "saigneur-candidat"
# ======================================================================
FROM adoptopenjdk/openjdk11:alpine-slim
LABEL maintainer = "apromac <abraham.tiene@apromac.ci>"

RUN mkdir /usr/local/microservice \
&& mkdir /usr/local/microservice/msaigneur

WORKDIR /usr/local/microservice/msaigneur
COPY target/*.jar saigneur-candidat.jar

EXPOSE 9003
ENTRYPOINT ["java", "-jar", "saigneur-candidat.jar"]
