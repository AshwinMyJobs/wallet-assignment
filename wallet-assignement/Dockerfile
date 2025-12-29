    FROM eclipse-temurin:17-jdk-alpine
    VOLUME /tmp
    ARG JAR_FILE=target/*.jar
    COPY ${JAR_FILE} wallet-assignment.jar
    ENTRYPOINT ["java","-jar","/wallet-assignment.jar"]
    EXPOSE 8080