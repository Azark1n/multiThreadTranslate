FROM eclipse-temurin:17-jre
WORKDIR /app
COPY ./build/libs/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]