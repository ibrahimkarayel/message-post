FROM openjdk:11.0.2-jdk-slim

ARG EXECUTABLE_ARTIFACT_NAME

WORKDIR /opt/app/java

ENV SERVER_PORT 8081

ADD target/message-posts.jar /opt/app/java/app.jar
# Run app.jar  when the container launches
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
