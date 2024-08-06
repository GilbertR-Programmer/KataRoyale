# Use the official Maven image as a parent image
FROM maven:3.8.5-openjdk-11

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and source code into the container
COPY pom.xml .
COPY src ./src

# Package the application using Maven
RUN mvn clean package

# Copy the packaged jar file into the final image
COPY target/KataRoyaleSite-1.0-SNAPSHOT.jar /app/KataRoyaleSite.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "/app/KataRoyaleSite.jar"]
