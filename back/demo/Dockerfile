FROM maven:3.8.6-openjdk-11 as builder
COPY pom.xml .
COPY src ./src
RUN mvn -f pom.xml package

FROM openjdk:11-jdk
COPY --from=builder ./target/*.jar ./boot/app.jar
COPY --from=builder ./src ./src
RUN apt-get -y update
RUN apt-get -y upgrade
RUN apt-get install -y ffmpeg
EXPOSE 8080

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=deploy", "boot/app.jar" ]