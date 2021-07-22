FROM jboss/base-jdk:8

#COPY target/SpringBootTech-1.0.0.jar /tmp/

WORKDIR /tmp/

#CMD ["java", "-jar", "SpringBootTech-1.0.0.jar"]

EXPOSE 9080
