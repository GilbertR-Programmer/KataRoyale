# DockerFile for KataRoyaleSite
FROM maven:3.9.7-eclipse-temurin-21 AS build
COPY . .
RUN mvn clean package -X -DskipTests

FROM eclipse-temurin:21-jdk
COPY --from=build /target/*.jar kataRoyale.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","kataRoyale.jar"]
