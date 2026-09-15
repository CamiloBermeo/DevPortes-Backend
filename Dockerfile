# Primero solo el pom.xml para cachear dependencias
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline -B

# Luego el código fuente
COPY src ./src
RUN ./mvnw package -DskipTests

# Stage 2 — runtime
FROM eclipse-temurin:21-jre-alpine AS runtime
WORKDIR /app

# Usuario no-root
RUN addgroup --system appgroup && adduser --system --ingroup appgroup appuser
USER appuser

# Solo el JAR del stage anterior
COPY --from=builder /app/target/devPortes-Backend-0.0.1-SNAPSHOT.jar app.jar


EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]