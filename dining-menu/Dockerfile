FROM openjdk:8-jdk-alpine
COPY ./target/dining-menu-0.0.1-SNAPSHOT.jar /app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 11001 
ENTRYPOINT ["java","-jar","/app.jar"]