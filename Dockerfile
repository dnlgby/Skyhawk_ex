FROM openjdk:17
WORKDIR /app
COPY target/nba-stats-1.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]