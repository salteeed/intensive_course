FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 7000
ARG JAR_FILE=build/libs/*.jar
ADD ${JAR_FILE} jenkins-dover-demo.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/jenkins-dover-demo.jar"]