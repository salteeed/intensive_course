FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 7000
ARG JAR_FILE=/workspace/*.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar"]