FROM openjdk:20-jdk-slim AS build
WORKDIR /app
COPY . .
RUN ./gradlew build


FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/build/lisbs/aws-project-1.0.0-SNAPSHOT.jar .
COPY docker-start.sh .
RUN chmod +x docker-startup.sh
EXPOSE 8080
CMD ["./docker-startup.sh"]