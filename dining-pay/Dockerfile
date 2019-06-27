FROM openjdk:8-jdk-alpine
COPY ./target/dining-pay-0.0.1-SNAPSHOT.jar /app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 11020
ENTRYPOINT ["java","-jar","/app.jar"]