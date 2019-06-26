FROM openjdk:8-jdk-alpine
EXPOSE 80
COPY /workspace/dining-account/target/dining-account-0.0.1-SNAPSHOT.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"] 
ENTRYPOINT ["java","-jar","/app.jar"]