FROM eclipse-temurin:17-jdk-alpine
COPY /ProductsMicroservice/target/products-microservice-0.0.1-SNAPSHOT.jar products-microservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/products-microservice-0.0.1-SNAPSHOT.jar"]