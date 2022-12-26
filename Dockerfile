FROM maven:3.8.3-openjdk-17 as builder
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml clean package
FROM openjdk:18.0-jdk-slim
COPY --from=builder /usr/src/app/target/AlcoholConverter-0.0.1-SNAPSHOT.jar /usr/app/AlcoholConverter-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/usr/app/AlcoholConverter-0.0.1-SNAPSHOT.jar"]