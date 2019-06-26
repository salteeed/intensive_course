FROM openjdk:8-jdk-alpine
EXPOSE 80
ARG JAR_FILE=/workspace/dining-account/target/dining-account-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"] 
ENTRYPOINT ["java","-jar","/app.jar"]