FROM eclipse-temurin:17-jdk-alpine
COPY target/ProductstMicroservice-0.0.1-SNAPSHOT.jar ProductstMicroservice-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/ProductstMicroservice-0.0.1-SNAPSHOT.jar"]