FROM ubuntu:latest AS build

RUN apt-get update && \
    apt-get install -y openjdk-21-jdk maven && \
    apt-get clean

WORKDIR /app

COPY pom.xml ./
RUN mvn dependency:go-offline

COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim

EXPOSE 8080

WORKDIR /app

COPY --from=build /app/target/*.jar ./my-app.jar

ENTRYPOINT ["java", "-jar", "./my-app.jar"]
