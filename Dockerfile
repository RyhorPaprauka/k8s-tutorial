FROM openjdk:8-jre-alpine
ADD target/*.jar run.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=prod", "-jar", "run.jar"]

