FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} app/app.jar
EXPOSE 9000/tcp
EXPOSE 9001/tcp
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","app/app.jar"]