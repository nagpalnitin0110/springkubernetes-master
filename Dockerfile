FROM openjdk:8-jdk-alpine

COPY target/SpringBootTech-1.0.0.jar /tmp/

WORKDIR /tmp/

CMD ["java", "-jar", "SpringBootTech-1.0.0.jar"]

EXPOSE 9080
