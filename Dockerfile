# Base image
FROM maven:3.9.9-amazoncorretto-23-debian AS build

WORKDIR /app

COPY pom.xml /app/
RUN mvn dependency:go-offline

# Kopieer de volledige applicatiebroncode
COPY src /app/src

# Voer de Maven build uit om het JAR-bestand te genereren
RUN mvn clean package -DskipTests


# Gebruik de Amazon Corretto 23 voor de uiteindelijke container
FROM amazoncorretto:23

WORKDIR /app
# Kopieer de gecompileerde JAR naar de uiteindelijke container
COPY --from=build /app/target/ChooseStock-1.0.0.jar /app/ChooseStock.jar

# Start de applicatie
ENTRYPOINT ["java", "-jar", "/app/ChooseStock.jar"]
