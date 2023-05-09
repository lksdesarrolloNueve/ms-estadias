FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/ms-almacen-divan/src
COPY pom.xml /home/ms-almacen-divan
RUN mvn -f /home/ms-almacen-divan/pom.xml clean package

FROM openjdk:11-jre-slim
COPY --from=build /home/ms-almacen-divan/target/ms-almacen-divan-0.0.1-SNAPSHOT.jar /usr/src/app/ms-almacen-divan-0.0.1-SNAPSHOT.jar
#EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/src/app/ms-almacen-divan-0.0.1-SNAPSHOT.jar"]