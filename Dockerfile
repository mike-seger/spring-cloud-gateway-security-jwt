FROM gradle:7-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon -i

FROM openjdk:11-jre-slim

EXPOSE 8080
EXPOSE 6000
EXPOSE 7000
EXPOSE 8761

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/app.jar

ENV SPRING_PROFILES_ACTIVE docker

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
