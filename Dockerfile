FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 80
#ARG JAR_FILE=/workspace/*.jar
#ADD ${JAR_FILE} jenkins-dover-demo.jar
ENTRYPOINT ["sh","-c", "pwd;ls -arl"]