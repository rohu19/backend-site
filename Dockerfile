
FROM openjdk:17
WORKDIR /usr/app/
COPY target/projectPool-0.0.1-SNAPSHOT.jar  /usr/app/

EXPOSE 9090
ENTRYPOINT ["java", "-jar", "projectPool-0.0.1-SNAPSHOT.jar"]