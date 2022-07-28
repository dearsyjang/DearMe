FROM maven:3.8.6-openjdk-11 as builder
COPY pom.xml .
COPY src ./src
RUN mvn -f pom.xml package

FROM openjdk:11-jdk
COPY --from=builder ./target/*.jar ./boot/app.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar", "boot/app.jar" ]