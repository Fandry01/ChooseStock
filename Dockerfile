# Base image
FROM maven:3.9.9-amazoncorretto-23-debian AS build

WORKDIR /app

# Copy only necessary files for caching
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Ensure Maven wrapper is executable
RUN chmod +x mvnw

# Download dependencies first for caching
RUN ./mvnw dependency:go-offline

# Copy rest of the project
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/app.jar"]
