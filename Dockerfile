FROM amazoncorretto:8-alpine-jdk
MAINTAINER lucasirustaDEV
COPY target/ABML-0.0.1-SNAPSHOT.jar ABML-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ABML-0.0.1-SNAPSHOT.jar"]