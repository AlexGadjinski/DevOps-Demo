FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /workspace
COPY . .
RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=builder /workspace/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]