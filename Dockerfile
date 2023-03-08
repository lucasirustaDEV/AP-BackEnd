FROM amazoncorretto:8-alpine-jdk
MAINTAINER lucasirustaDEV
COPY target/ABML-0.0.1-SNAPSHOT.jar pfap-app.jar
ENTRYPOINT ["java","-jar","/pfap-app.jar"]