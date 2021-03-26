#FROM openjdk:11-jdk-oracle-alpine
FROM azul/zulu-openjdk-alpine:11
MAINTAINER tpalucki.github.io
COPY target/grammati-0.0.3-SNAPSHOT.jar grammati-0.0.3-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/grammati-0.0.3-SNAPSHOT.jar"]