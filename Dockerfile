# Base image
FROM maven:3.9.9-amazoncorretto-23-debian AS build

# Set working directory
WORKDIR /app

# Copy Maven wrapper
COPY mvnw mvnw
COPY .mvn .mvn

# Copy full project
COPY . .

# Ensure Maven wrapper is executable
RUN chmod +x ./mvnw

# Clean & build project
RUN ./mvnw clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/*.jar"]
