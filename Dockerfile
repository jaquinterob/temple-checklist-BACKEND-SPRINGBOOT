FROM openjdk:17
EXPOSE 8080
RUN mkdir -p /app/
ADD build/libs/temple-checklist-0.0.1-SNAPSHOT.jar /app/temple-checklist-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/temple-checklist-0.0.1-SNAPSHOT.jar"]