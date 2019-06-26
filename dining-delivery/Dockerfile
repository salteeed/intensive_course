FROM openjdk:8-jdk-alpine
COPY ./dining-delivery/target/dining-delivery-0.0.1-SNAPSHOT.jar /app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
EXPOSE 11001
ENTRYPOINT ["java","-jar","/app.jar"]