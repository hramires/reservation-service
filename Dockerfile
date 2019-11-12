FROM openjdk:8u232-jdk-slim

EXPOSE 8080

RUN mkdir -p /opt/application/jar
WORKDIR /opt/application/jar
COPY build/libs/reservation-service-0.0.1-SNAPSHOT.jar /opt/application/jar/reservation-service-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java", \
    "-jar", \
    "/opt/application/jar/reservation-service-0.0.1-SNAPSHOT.jar" ]