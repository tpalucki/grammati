FROM azul/zulu-openjdk-alpine:11

MAINTAINER tpalucki.github.io

COPY target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]