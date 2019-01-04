FROM openjdk:8

VOLUME /tmp

WORKDIR /app

COPY /build/target/*.jar /app

ENV SPRING_PROFILES_ACTIVE = prod

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/service.jar"]