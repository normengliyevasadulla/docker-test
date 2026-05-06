FROM maven:3.9.6-eclipse-temurin-17-alpine AS build
LABEL authors="asadulla"

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# 2-Bosqich: Run (Faqat ishga tushirish)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Build bosqichidan faqat JAR faylni nusxalab olamiz
COPY --from=build /app/target/*.jar /app.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "/app.jar"]