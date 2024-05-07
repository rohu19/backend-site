
FROM openjdk:17
WORKDIR /usr/app/
COPY target/poolBackendSide-0.0.1-SNAPSHOT.jar  /usr/app/

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "poolBackendSide-0.0.1-SNAPSHOT.jar"]