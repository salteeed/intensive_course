FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 80
ENTRYPOINT ["sh","-c", "while true; echo hello; do sleep 1000; done;"]