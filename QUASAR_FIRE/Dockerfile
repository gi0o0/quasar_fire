FROM openjdk:8-jdk-alpine
LABEL maintainer="mercadolibre@mercadolibre.com"
WORKDIR /workspace

COPY target/quasar_fire-*.jar app.jar

RUN apk update && \
    apk add --no-cache tzdata

ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080